package com.application.philpenriskassessment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormViBinding

class FormVIFragment : Fragment() {
    private lateinit var binding: FragmentFormViBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormViBinding.inflate(inflater,container,false)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_formVIFragment_to_formVFragment)
        }

        binding.next.setOnClickListener {

            val age = requireArguments().getInt("age")
            val sex = requireArguments().getString("sex")
            val sbp = requireArguments().getInt("sbp")
            val smoker = requireArguments().getString("smoker")
            val cholesterol = binding.cholesterol.text.toString().toInt()


            val childBundle = Bundle()
            childBundle.putInt("age", age)
            childBundle.putString("sex", sex)
            childBundle.putInt("sbp", sbp)
            childBundle.putString("smoker", smoker)
            childBundle.putInt("cholesterol", cholesterol)

            findNavController().navigate(R.id.action_formVIFragment_to_formVIIFragment, childBundle)

        }

        return binding.root
    }

}