package com.application.philpenriskassessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentReferBinding

class ReferFragment : Fragment() {
    private lateinit var binding: FragmentReferBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReferBinding.inflate(inflater,container,false)

        binding.home.setOnClickListener {
            findNavController().navigate(R.id.action_referFragment_to_homeFragment)
        }
        return binding.root
    }
}