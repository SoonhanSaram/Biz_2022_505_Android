package com.kyoungmin.student.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyoungmin.student.adapter.StudentRecyclerAdapter
import com.kyoungmin.student.databinding.FragmentMainListBinding
import com.kyoungmin.student.models.StudentViewModel


class MainListFragment : Fragment() {
    private lateinit var binding : FragmentMainListBinding
    private val studentViewModel : StudentViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val studentAdapter = StudentRecyclerAdapter(studentViewModel.studentList)
        with(binding.studentList) {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }
        // 원래 위 코드
        // binding.studentList.layoutManager = LinearLayoutManager(context)
        // binding.studentList.adapter = studentAdapter

         studentViewModel.studentList.observe(viewLifecycleOwner, Observer { studentAdapter.modifyNotice() })

        // floating button 을 클릭하면 임의 학생정보를 배열에 추가하기
        binding.btnAdd.setOnClickListener{
            studentViewModel.add()
        }
    }
}