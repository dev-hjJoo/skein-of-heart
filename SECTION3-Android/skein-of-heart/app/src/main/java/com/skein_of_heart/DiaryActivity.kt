package com.skein_of_heart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_diary.*
import kotlinx.android.synthetic.main.activity_main.*

class DiaryActivity : AppCompatActivity() {
    // 테스트 다이어리 데이터베이스 예제
    var libraryname = arrayOf("나의 일기", "내일 일기")
    var diaryletter1 = arrayOf("오늘 심심했음", "졸작하기시렁", "게임 재밌다 캬캬캬캬", "살 오지게찜..ㅠㅠ")
    var diaryimg1 = arrayOf(R.drawable.library_img1,R.drawable.library_img1,R.drawable.library_img1,R.drawable.library_img2)
    var diaryletter2 = arrayOf("1. 숨쉬기 2. 잠자기 3. 고양이랑 놀기", "롤체 승격하기", "오늘은 진짜 진짜 진짜 졸작 만들어야한다")
    var diaryimg2 = arrayOf(R.drawable.library_img2,0,R.drawable.library_img1)
    var diary1 = ArrayList<HashMap<String, Any>>()
    var diary2 = ArrayList<HashMap<String, Any>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)



        // 메인 화면에서 받아온 일기장의 숫자

        var libraryname = 0
        if (intent.hasExtra("librarynum")){
            libraryname =  intent.getIntExtra("librarynum", 1)
            diaryTitle.text = intent.getStringExtra("libraryname")
        }

        // 라이브러리 예제 다이어리 1
        var idx = 0
        while(idx < diaryletter1.size){
            var map = HashMap<String, Any>()    // 리스트 예제
            map.put("diaryImg", diaryimg1[idx])
            map.put("diaryLetter", diaryletter1[idx])
            diary1.add(map)
            idx++
        }






        //라이브러리 예제 다이어리 2
        idx =0
        while(idx < diaryletter2.size){
            var map = HashMap<String, Any>()    // 리스트 예제
            map.put("diaryImg", diaryimg2[idx])
            map.put("diaryLetter", diaryletter2[idx])
            diary2.add(map)
            idx++
        }
        var diarydata = arrayOf(diary1,diary2)


        var keys = arrayOf("diaryImg","diaryLetter")
        var ids = intArrayOf(R.id.diaryImg, R.id.diaryText)





        var diaryAdapter = SimpleAdapter(this, diarydata[libraryname], R.layout.diary_img, keys, ids)
        diaryList.adapter = diaryAdapter

    }




}

