package com.kyoungmin.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NewWordActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word2)
        
        // MainActivity 에서 putextra로 전달된 변수 값 추출
        val Hello = intent.getStringExtra("Hello")
        val num1 = intent.getIntExtra("num1",0)
        val num2 = intent.getIntExtra("num2",0)

        Log.d("new hello",Hello.toString())
        Log.d("new num1", num1.toString())
        Log.d("new num2", num2.toString())
    }
}