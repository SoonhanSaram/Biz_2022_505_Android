package com.kyoungmin.student.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.kyoungmin.student.data.Student
import com.kyoungmin.student.databinding.StudentListItemBinding

/**
 * RecyclerView 에 데이터를 보여주기위한
 * Helper class
 *
 * 클래스를 상속받았을 때 강제로 member 들을 implement 해야하는 경우가 있음
 * -> 원본 클래스가 인터페이스 이거나 추상클래스일 경우
 * 
 * 클래스를 상속받았을 때 오류가 발생하고
 * implements member 메시지가 나오면 method 를 추가해 
 * 코드를 작성해야 함
 */
class StudentRecyclerAdapter(private val studentList: LiveData<List<Student>> // 화면에 보여줄 데이터 받기
 ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    /**
     * fragment 나 activity 에서 
     * xml 파일과 binding 을 연결하는 역할을 수행하는 함수
     * 여기선 RecyclerView 를 위해 작동하는 함수
     * 아래서 만든 binding 을 ViewHolder 에게 전달해
     * Data 와 View 를 연결
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val studentHolder =
        StudentListItemBinding.inflate(LayoutInflater.from(parent.context),
        parent, false)
        return StudentViewHolder(studentHolder)
    }
    // 개별 데이터와 view 를 연결하는 함수
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = studentList.value?.get(position)
        val stHolder = holder as StudentViewHolder
        stHolder.bind(item!!)
    }

    override fun getItemCount(): Int = if(studentList.value == null) 0 else studentList.value?.size!!
    // override fun getItemCount(): Int {
    //    studentList.value?.size!!
    // }

    fun modifyNotice() {
        notifyDataSetChanged()
    }

    /**
     * 1
     * 리스트로 보여줄 개별 데이터의 view 를 설정하는 부분
     * student_list_item_xml 을 bindiong 으로 전달
     * 2
     * 상속받은 RecyclerView.ViewHolder에게
     * binding.root 를 전달
     */
    inner class StudentViewHolder(private val binding:StudentListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun bind(student:Student){
                /**
                 * 매개변수로 전달받은 student 객체와
                 * binding.stView 를 연결
                 * 
                 * DataBinding 을 이용해
                 * UI 와 viewModel 을 연동하기 위해
                 * Call by Reference 를 이용하는 방법
                 */
                binding.stView = student
            }
        }
}