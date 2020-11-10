from django.db import models
from django.utils.translation import gettext_lazy as _

# 일기장 내 각각의 글
class Page(models.Model):
    no = models.AutoField(primary_key=True)
    diary_no = models.IntegerField(null=False)

    # topic_no[0]: 선택 안 함/ 그 외: 선택한 토
    topic_no = models.IntegerField(default=0)
    # 일기 내용
    content = models.CharField(max_length=1000, blank=True, null=True)
    datetime = models.DateTimeField()

    # 감정 점수 수치화 값
    emotion_score = models.IntegerField()
    emotion_state = models.CharField()

# page 묶음
class Diary(models.Model):
    no = models.AutoField(primary_key=True)
    title = models.CharField(max_length=10)

    class COLOR_SET(models.TextChoices):
        RED = 'RD', _('Red')
        ORANGE = 'OR', _('Orange')
        YELLOW = 'YL', _('Yellow')
        YELLOWGREEN = 'YG', _('YellowGreen')
        GREEN = 'GN', _('Green')
        SKYBLUE = 'SB', _('SkyBlue')
        BLUE = 'BL', _('Blue')
        VIOLET = 'VT', _('Violet')
        PINK = 'PK', _('Pink')
        BLACK = 'BK', _('Black')
        GRAY = 'GY', _('Gray')
        WHITE = 'WT', _('WHITE')

    color = models.CharField(
        max_length=2,
        choices=COLOR_SET.choices,
        default=COLOR_SET.WHITE
    )

    create_datetime = models.DateTimeField()
    update_datetime = models.DateTimeField()


class User(models.Model):
    no = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=5)
    age = models.IntegerField()
    id = models.CharField(max_length=10)
    password = models.CharField(max_length=20)