package com.kyoungmin.list

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kyoungmin.app.databinding.ActivityMainBinding
import com.kyoungmin.list.models.StudentModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val stViewModel: StudentModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //viewModel 에서 생성된 데이터 확인
        val studentList = stViewModel.studentList
        studentList.forEach {
            Log.d("MAIN", "${it.name} ${it.address} ${it.tel}")
        }
    }
}