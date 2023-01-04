package com.kyoungmin.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kyoungmin.app.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding ? = null
    private val binding get() = _binding

    /**
     * Activity에서는 주로 onCreate Method에서 view를 만들고
     * binding을 수행
     * Fragment에서는 ocCreateView Method에서 수행
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // LayoutInflater 와 ViewGroup을 사용해 binding 수행
        _binding = FragmentMainBinding.inflate(inflater, container,false)
        
        // binding 객체가 정상적으로 생성되어 있을 때만 .root 값을 get
        // root 변수에 할당
        // !! : 절대 null 금지
        val root : View = binding!!.root
        // Inflate the layout for this fragment

        binding!!.btnGoSub.setOnClickListener{
//            Snackbar.make(it, "안녕", Snackbar.LENGTH_LONG).show()
//            findNavController().navigate(R.id.action_mainFragment_to_subFragment)
            /**
             * fragment간에 안전한 데이터 교환을 하기위한 도구
             * safe-args-plugin을 설치하면 
             * Fragment에 따라서 FragmenDirections 클래스가 자동 생성
             * Directions 에게 값을 저장하여 다른 Fragment로 전달
             */
        val action = MainFragmentDirections.actionMainFragmentToSubFragment()
            action.word = binding!!.inputWord.text.toString()
//            action.age = 9
            findNavController().navigate(action)
        }
        return root
        //return inflater.inflate(R.layout.fragment_main, container, false)
    }

}