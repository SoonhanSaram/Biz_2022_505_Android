package com.kyoungmin.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyoungmin.app.databinding.StudentListItemBinding
import com.kyoungmin.list.models.StudentDto

/**
 * Adapter 클래스
 * 복잡한 UI 구현하거나,
 * 복잡한 연산을 수행할 때 기본코드만으로 구현이 어려운 부분이 있음
 * 안드로이드에서는 데이터를 RecyclerView 에 표현할 때
 * 많은 설정이 필요
 * 이러한 설정을 하는 별도의 모듈을 생성해야 함
 *
 * Helper class ; 설정을 별도로 만들고 연결하는 도구로 사용하는 클래스
 * Adapter 클래스도 Helper 클래스 중 하나
 * RecyclerViewAdapter 는 RecyclerView 만을위해 작성하는 클래스파일
 *
 * implements member (method)
 * RecyclerViewAdapter 를 만들 떈 RecyclerView.Adapter 클래스를 반드시 상속받고
 * 3개의 함수를 반드시 코딩
 * 3개의 함수를 통해 RecyclerView 의 item 들을 화면에 표현
 *
 * (private val studentList: MutableList<StudentDto>)
 * 학생정보들이 저장된 배열을 받아서 사용
 */
class StudentRecyclerAdapter(private val studentList: MutableList<StudentDto>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHoler = StudentViewHolder(
            StudentListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return viewHoler
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // List 에서 1개의 데이터를 추출해
        val item = studentList[position]
        val stholder = holder as StudentViewHolder

        // 개별데이터를 view 의 text 속성에 setting
        stholder.txtStName.text = item.name.toString()
        stholder.txtStNum.text = item.num.toString()
        stholder.txtStAddr.text = item.address.toString()
        stholder.txtStTel.text = item.tel.toString()
    }

    // 전체 화면에 보일 데이터 개수를 return 하는 함수
    override fun getItemCount(): Int {
        return studentList.size
    }

    /**
     * student_list_item.xml 에 설정된 view 를 사용할 수 있도록
     * binding 처리를 해줄 Helper 클래스
     *
     * (binding: StudentListItemBinding)
     * layout/student_list_item.xml 파일을 binding 객체로 생성하는 코드
     */
    inner class StudentViewHolder(binding: StudentListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //xml 에 개별 변수 할당
        val txtStNum: TextView = binding.stNum
        val txtStName: TextView = binding.stName
        val txtStAddr: TextView = binding.stAddr
        val txtStTel: TextView = binding.stTel
    }

}