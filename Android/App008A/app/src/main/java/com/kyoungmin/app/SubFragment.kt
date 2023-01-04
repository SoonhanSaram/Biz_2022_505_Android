package com.kyoungmin.app


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kyoungmin.app.databinding.FragmentSubBinding


class SubFragment : Fragment() {
    /**
     * 실제 binding 된 view가 저장될 _binding 변수와
     * binding get() : _binding 데이터를 읽기 위한 get 함수선언
     * Fragment에서 메모리 누수를 방지하기위한 설정
     */
    private var _binding : FragmentSubBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubBinding.inflate(inflater, container,false)
        /**
         * get () method
         * _binding 객체를 직접 접근해 데이터를 참조하지 않고
         * binding get() 함수를 통해 간접 접근
         * binding get() 함수를 선언 할 때
         *      _binding !! 을 참조하도록 만들었기에
         *      !! 를 사용하지 않아도 된다
         * binding에 접근을 하면 그 때마다 _binding으로부터
         * 데이터를 가져와 참조 할 수 있도록 만듦
         */
        val root = binding.root

        val txtView = binding.txtView
        txtView.setOnClickListener{
            findNavController().navigate(R.id.action_subFragment_to_mainFragment)
        }
        // by navArgs() : navArgs() 함ㅅ구를 lazy로 호출해 args 값을 찾기
        val args : MainFragmentArgs by navArgs()
        //args.변수 값을 get해 txtView text 속성에 setting
        txtView.text = "${args.word}"
        // Inflate the layout for this fragment
        return root
    }
}