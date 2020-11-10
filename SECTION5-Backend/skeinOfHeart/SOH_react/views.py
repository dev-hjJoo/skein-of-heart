from django.shortcuts import render
from rest_framework.decorators import api_view
from konlpy.tag import Okt  # 형태소 분석기 (말뭉치)
import re  # 문자열 정규표현식 지원 모듈
import datetime
from hanspell import spell_checker
from django.http import HttpResponseNotFound


def preprocessContent(content):
    return re.sub(r'[^ ㄱ-ㅣ가-힣1-9]', '', content)  # 한글/숫만 추출 (정규 표현식 사용, 영어 추가하려면 A-Za-z 추가)

def tokenizerBook(content):
    okt = Okt()
    # 형태소별 자른 토큰 리스트
    tokens = []

    # 불용어 처리
    stop_words = ['함초롬바탕', '고딕']
    content = re.sub(r'[^ ㄱ-ㅣ가-힣]', '', content)
    token = okt.morphs(content, stem=True)
    # 조사 제외 단어 추출 and 길이 2이상 단어
    tokens = [each_word for each_word in token if each_word not in stop_words]

    return tokens


def makeVocaAnalysis(content, user_no):
    # voca_table = total_voca.objects.filter(user_no=user_no)

    if len(voca_table) != 0:
        voca_table = voca_table[0]
        prev = voca_table.words
        result = prev.split(',')
    else:
        result = []

    book_voca = tokenizerBook(content)
    count = 0
    for voca in book_voca:
        if voca not in result:
            count += 1
            result.append(voca)
    result = toString(result)


    # # total_voca 테이블 저장
    # try:
    #     voca_table.words = result
    #     voca_table.save()
    # except:
    #     voca_table = total_voca(user_no=user_no, words=result)
    #     voca_table.save()
    #
    # # stack_voca_count 테이블 저장
    # stack_voca = stack_voca_count(user_no=user_no, count_increment=count)
    # stack_voca.save()

    return (voca_table.words, count)


def countVoca(tokens):
    return len(tokens)


def toString(strList):
    result = ''
    for text in strList:
        if result == '':
            result = text
        else:
            result = result + ',' + text

    return result

def correctContent(content):
    content = preprocessContent(content)
    result = spell_checker.check(preprocessContent(content))
    result = result.as_dict()
    return result

@api_view(['POST'])
def index(request):
    return render(request)

@api_view(['POST'])
def correct(request):
    content = request.GET.get('content', False)
    result = correctContent(content)

    return render(request, 'SOH_react/index.html', {'result': result})