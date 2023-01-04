package com.kyoungmin.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kyoungmin.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // view Binding을 활성화해 사용하기 위한 객체 선언
    // Kotlin은 변수를 선언함과 동시에 초기화하는 것이 원칙
    // 경우에 따라서 선언과 초기화를 분리시키는 경우가 있음
    // -> lateinit var 키워드를 사용해 변수를 선언
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding을 사용하기위해 초기화(값 할당)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}