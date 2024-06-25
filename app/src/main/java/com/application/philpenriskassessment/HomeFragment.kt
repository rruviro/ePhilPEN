package com.application.philpenriskassessment

import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.info.setOnClickListener {
            showInformation()
        }

        binding.form.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formFragment)
        }

        return binding.root
    }

    private fun showInformation() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(R.layout.info_dialog).
        show()
    }

}