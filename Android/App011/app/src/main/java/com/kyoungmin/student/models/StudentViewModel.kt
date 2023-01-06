package com.kyoungmin.student.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kyoungmin.student.data.Student
import com.kyoungmin.student.data.studentStringList

// 배열의 index 를 미리 변수로 설정
const val st_NUM = 0
const val st_NAME = 1
const val st_DEPT = 2
const val st_GRADE = 3
const val st_ADDR = 5
const val st_TEL = 6

class StudentViewModel: ViewModel() {
    /**
     * 학생정보 리스트를 관리 할 data
     */
    private val _studentlist = mutableListOf<Student>()


    /**
     * 원본 데이터는 List<Student> 인데
     * 이 데이터를 viewModel 에서 관리하기위해
     * List<Student> 를 MutableLiveData 로 감싼다
     */
    val studentList = MutableLiveData<List<Student>>()
//    init {
//        _studentlist.add(Student())
//        studentList.value = _studentlist
//    }
    fun add() {
        // StudentData 에 있는 학생정보 문자열을 random 으로 가져오기
    /**
     * PC 코드에서 사용하는 random() 함수들
     * 컴퓨터의 시간값을 내부에서 연산을 통해 어떤 값을 만들고
     *  그 값을 index로 해 random 값을 생성
     *  
     *  때문에 PC 코드의 random() 함수가 return 하는 값을
     *  의사난수, 유사난수라고 함
     *  중복된 값이 많이 나타남
     */
    val studentString = studentStringList.random()
        val items : List<String> = studentString.split(":")

        val student = Student(
            stNum = items[st_NUM],
            stName = items[st_NAME],
            stDept = items[st_DEPT],
            stAddr = items[st_ADDR],
            stTel = items[st_TEL],
            stGrade = items[st_GRADE].toInt()
        )
        _studentlist.add(student)
        studentList.value = _studentlist
    }
}