package com.example.sharedvmapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.sharedvmapp.databinding.FragmentFirstBinding
import com.example.sharedvmapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater)
        sharedViewModel.score.observe(viewLifecycleOwner){
            binding.secondButton.text = it.toString()
        }
        binding.secondButton.setOnClickListener {
            sharedViewModel.score.let {
                it.postValue(it.value?.plus(1) ?: 0)
            }
        }
        return binding.root
    }

}