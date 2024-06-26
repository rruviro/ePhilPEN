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

        val age = requireArguments().getInt("age")
        val sex = requireArguments().getString("sex")
        val sbp = requireArguments().getInt("sbp")
        val smoker = requireArguments().getString("smoker")
        val cholesterol = requireArguments().getInt("cholesterol")
        val checker =  sex + sbp + smoker + cholesterol + age
        binding.title.text = checker

        //algorithm
        val green = 10
        val yellow = 20
        val orange = 30
        val red = 40
        val deepRed = 40

        val patientCalculation = age + cholesterol + sbp
        if (sex == "Male") {
            if (smoker == "smoker"){
                if (patientCalculation < green) {
                    binding.results.setBackgroundColor(Color.GREEN)
                } else if (patientCalculation < yellow) {
                    binding.results.setBackgroundColor(Color.YELLOW)
                } else if (patientCalculation < orange) {
                    binding.results.setBackgroundColor(Color.parseColor("#FFCC99"))
                } else if (patientCalculation < red) {
                    binding.results.setBackgroundColor(Color.RED)
                } else if (patientCalculation > deepRed) {
                    binding.results.setBackgroundColor(Color.parseColor("#C70039"))
                }
            } else {
                Toast.makeText(context, "non-smoker/male", Toast.LENGTH_SHORT).show()
            }
        } else {
            if (smoker == "smoker"){
                Toast.makeText(context, "smoker/female", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "non-smoker/female", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}

