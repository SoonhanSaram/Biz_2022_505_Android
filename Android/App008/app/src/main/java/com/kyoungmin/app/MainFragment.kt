package com.kyoungmin.app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kyoungmin.app.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding ? = null
    private val binding get () = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val root = binding.root



        binding!!.btnAdd.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToResultFragment()
            var inputText = binding.InputBox
            var word = inputText.text.toString()
            action.eword = word
            findNavController().navigate(action)
        }





        // Inflate the layout for this fragment
        return root
    }
}