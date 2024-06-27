package com.application.philpenriskassessment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)

        val bundleAge = requireArguments().getString("age")!!.toInt()
        val bundleSex = requireArguments().getString("sex")
        val bundleSbp = requireArguments().getString("sbp")!!.toInt()
        val bundleSmoker = requireArguments().getString("smoker")
        val bundleCholesterol = requireArguments().getString("cholesterol")!!.toInt()

        val checker =  bundleSex + bundleAge + bundleSmoker + bundleCholesterol + bundleSbp
        binding.title.text = checker

        //algorithm
//        if (bundleAge in 40..49 && bundleSmoker == "non-smoker" && bundleSbp in 140..159 && bundleCholesterol in 155..310) {
//            binding.results.setBackgroundColor(Color.GREEN)
//        } else if (bundleSex == "Female" && bundleAge in 40..49 && bundleSmoker == "non-smoker" && bundleSbp in 160..179 && bundleCholesterol in 155..310){
//            if (bundleSex == "Male") {
//                //orange
//                binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
//            } else {
//                //dilaw
//                binding.results.setBackgroundColor(Color.YELLOW)
//            }
//        } else if (bundleAge in 40..49 && bundleSmoker == "non-smoker" && bundleSbp >= 180 && bundleCholesterol >= 310) {
//            //deep red
//            binding.results.setBackgroundColor(Color.parseColor("#C70039"))
//        } else if (bundleAge in 40..59 && bundleSmoker == "non-smoker" && bundleSbp in 120..139 && bundleCholesterol >= 310) {
//            binding.results.setBackgroundColor(Color.GREEN)
//        } else if (bundleAge in 40..59 && bundleSmoker == "non-smoker" && bundleSbp in 140..159) {
//            if (bundleCholesterol >= 310) {
//                if (bundleSex == "Male") {
//                    binding.results.setBackgroundColor(Color.YELLOW)
//                } else {
//                    binding.results.setBackgroundColor(Color.GREEN)
//                }
//            }
//        } else if (bundleAge in 40..59 && bundleSmoker == "non-smoker" && bundleSbp in 140..159 && bundleCholesterol in 271..309) {
//            binding.results.setBackgroundColor(Color.GREEN)
//        } else if (bundleAge in 40..59 && bundleSmoker == "non-smoker" && bundleSbp in 160..179 && bundleCholesterol in 271..309) {
//            if (bundleSex == "Male") {
//                binding.results.setBackgroundColor(Color.YELLOW)
//            } else {
//                binding.results.setBackgroundColor(Color.GREEN)
//            }
//        } else if ()

        binding.home.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_referFragment)
        }

        return binding.root
    }

}

