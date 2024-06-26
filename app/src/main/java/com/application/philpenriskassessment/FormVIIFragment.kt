package com.application.philpenriskassessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormViiBinding

class FormVIIFragment : Fragment() {
    private lateinit var binding : FragmentFormViiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormViiBinding.inflate(inflater,container,false)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_formVIIFragment_to_formVIFragment)
        }

        binding.next.setOnClickListener {

            val age = requireArguments().getInt("age")
            val sex = requireArguments().getString("sex")
            val sbp = requireArguments().getInt("sbp")
            val smoker = requireArguments().getString("smoker")
            val cholesterol = requireArguments().getInt("cholesterol")

            val childBundle = Bundle()
            childBundle.putInt("age", age)
            childBundle.putString("sex", sex)
            childBundle.putInt("sbp", sbp)
            childBundle.putString("smoker", smoker)
            childBundle.putInt("cholesterol", cholesterol)

            findNavController().navigate(R.id.action_formVIIFragment_to_resultFragment, childBundle)
        }

        return binding.root

    }

}