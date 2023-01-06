package com.kyoungmin.puzzle.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kyoungmin.puzzle.R
import com.kyoungmin.puzzle.databinding.FragmentMyWordBinding
import com.kyoungmin.puzzle.databinding.FragmentSearchResultBinding


class MyWordFragment : Fragment() {
    private lateinit var binding: FragmentMyWordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMyWordBinding.inflate(inflater,container,false)
        return binding.root
    }

}