package com.example.sharedvmapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sharedvmapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater)
        sharedViewModel.score.observe(viewLifecycleOwner){
            binding.firstButton.text = it.toString()
        }
        binding.firstButton.setOnClickListener {
            sharedViewModel.score.let {
                it.value = it.value?.plus(1) ?: 0
            }
        }
        return binding.root
    }

}