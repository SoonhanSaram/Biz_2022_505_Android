package com.kyoungmin.list.models

import androidx.lifecycle.ViewModel
import com.kyoungmin.app_010_list.studentStringList

const val ST_NUM = 0
const val ST_NAME = 1
const val ST_DEPT = 2
const val ST_GRADE = 3
const val ST_ADDR = 5
const val ST_TEl = 6


class StudentModel : ViewModel() {
    /**
     * List<type> 데이터 : 요소를 추가, 삭제할 수 있는 배열
     * MutableList<StudentDto> : StudentDto type의 데이터만 저장할 수 있는
     *      배열 생성
     */
    val studentList: MutableList<StudentDto> = mutableListOf()

    init {
        getStudentList()
    }

    /**
     * 콜론(:) 구분자로 구분된 데이터 문자열을 분해해
     * StudentDto 객체로 만들고
     * 객체를 studentList 로 변환하는 함수
     */
    private fun getStudentList() {
        studentStringList.forEach {
            // split (구분자) : 문자열을 구분자로 분해해 
            // 배열로 만들어주는 함수
            val items: List<String> = it.split(":")
            // Log.d("Model", items[1])

            val student = StudentDto(
                num = items[ST_NUM],
                name = items[ST_NAME],
                dept = items[ST_DEPT],
                grade = items[ST_GRADE].toInt(),
                address = items[ST_ADDR],
                tel = items[ST_TEl]
            )
            studentList.add(student)
        }
    }
}