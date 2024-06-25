package com.application.philpenriskassessment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.application.philpenriskassessment.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        val bundle = arguments?.getString("value1")
        val bundle2 = arguments?.getString("data_key2")

        if (bundle != null && bundle2 != null) {
            binding.title.text = bundle + bundle2
        } else {
            Toast.makeText(context, "Data not received", Toast.LENGTH_SHORT).show()
        }

//        val gender = "male"
//        val status = "smoker"
//        val age = "40"
//        val sbp = "120"
//        if (gender == "male" && status == "smoker" && age == "40" && sbp == "120"){
//                binding.results.setBackgroundColor(Color.BLUE)
//            } else {
//                Toast.makeText(context, "tae", Toast.LENGTH_SHORT).show()
//            }

        return binding.root
    }

}

