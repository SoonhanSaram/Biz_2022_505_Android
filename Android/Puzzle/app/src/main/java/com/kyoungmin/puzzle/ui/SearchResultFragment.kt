package com.kyoungmin.puzzle.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kyoungmin.puzzle.databinding.FragmentSearchResultBinding


class SearchResultFragment : Fragment() {
    private lateinit var binding : FragmentSearchResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchResultBinding.inflate(inflater,container,false)
        return binding.root
    }
}