package com.kyoungmin.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

/**
 * main.xml에 있는 2개의 view를 Code에서 사용하기 위한
 * 객체 선언
 */
private lateinit var textView : TextView
private lateinit var inputText : TextInputEditText
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // layout xml 구성파일을 직접 가져와서 화면을 구현하는 코드
        // R : resource 폴더
        // R.layout : res 폴더 하위 layout 폴더
        // activity_main.xml 을 가지고 화면을 구성
        setContentView(R.layout.activity_main)
        
        // main.xml 에 설치된 2개의 view를 객체 변수에 할당
        textView = findViewById(R.id.text_view)
        inputText = findViewById(R.id.input_text)

        // 속성 setting : set**()
        // textView.setText("우리나라만세")
        textView.text = "우리나라만세"
        
        
        // inputText.setOnKeyListener()
        // 모든 키보드의 action을 capture event
        // 최근 안드로이드에서 버그 발견
        // 한번 Enter를 입력하고나면
        // 키보드가 먹통되는 현상

        /**
         * input box inputType = "text"로 하면
         * 키보드에 줄바꿈이 아니라 "완성 Enter" 표시
         * 완선 Enter가 눌렸을 때 발생하는 Event 핸들러
         *
         * lambda 방식으로 구현한 event 핸들러
         */
        inputText.setOnEditorActionListener{view, keyCode, event->
            // input box에 입력된 문자열만 text 변수에 할당
            val text = inputText.text.toString()

            //Console logcat에 메시지 보이기
            Log.d("Main", text)
            // textView에 표시
            textView.text = text
            
//            event 실행이 모두 완료됨을 알림
            true
        }
    }
}
