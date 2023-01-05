package com.kyoungmin.game.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.kyoungmin.game.MainActivity
import com.kyoungmin.game.R
import com.kyoungmin.game.databinding.FragmentResultBinding
import com.kyoungmin.game.models.WordViewModel


class ResultFragment : Fragment() {

    private lateinit var binding : FragmentResultBinding
    private val wordViewModel : WordViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    } // end createView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.wordViewModel = wordViewModel
        binding.btnReturn.setOnClickListener{
            val mainActivity = activity as MainActivity
            mainActivity.changeFragment(FRAGMENT_MAIN)
        }
        val inputText = wordViewModel.inputWord.value.toString()
        val unscrambleText = wordViewModel.unscrambleWord.value.toString()

        Log.d("정답 수", "${wordViewModel.gameScore.value}")
        Log.d("게임 수", "${wordViewModel.gameCount.value}")
        Log.d("메시지", "${wordViewModel.gameMsg.value}")
        // if를 사용하여 단어 비교
    }

    override fun onDestroy() {
        super.onDestroy()
        wordViewModel.inputWord.value = null
    }
}