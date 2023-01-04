package com.kyoungmin.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// addWord 변수에게 너의 type 은 Float... 라고 선언하는 방식
//        val addWord:FloatingActionButton = findViewById(R.id.add_word)
//        val getResultText = registerForActivityResult()
//        findViewById() 함수가 return하는 type이 Float..라고 선언
//         <FloatActionButton> 으로 설정한 type과 R.id.add_word로 선택된 대상이
//        완전히 일치하는 type이 아니면 컴파일 오류 발생
//        <> 사이에 type을 명시하는 것 :  Generic 설정
            val addWord = findViewById<FloatingActionButton>(R.id.add_word)
        addWord.setOnClickListener{

        /**
         * MainActivity 에서 다른 Activity 화면 열기
         * Activity
         * 
         * NewWordActivity::class.java
         * Kotlin으로 작성한 class 파일(*.kt, 소스코드)은
         * 컴파일이 된 후 java class 파일(.class)로 생성
         * 
         * Intent 라는 클래스에게
         * java class 파일인 NewWordActivity.class 파일을 가져와서
         * 화면에 띄우기 -> class Loader
         */
        val intent = Intent(this@MainActivity, NewWordActivity2::class.java)
            .apply {
                // 새로 열리는 Activity에게 var Hello = "반갑습니다"처럼 변수를
                // 만들어서 데이터를 전달하는 방법
                putExtra("Hello","반갑습니다")
                putExtra("Num1",3000)
                putExtra("Num2",2000)
            }
        //getResultText.launch(intent)
        
        // 단순히 intent로 설정된대로 다른 Activity를 여는 방법
        startActivity(intent)
            } //end fab onClick
        val phoneCallBtn = findViewById<FloatingActionButton>(R.id.phone_call)
        phoneCallBtn.setOnClickListener{
            //PhoneCall Activity가 화면에 나타나도록
            val change = Intent(this@MainActivity, PhoneCallActivity::class.java)

            startActivity(change)
        }
        } 
   }

