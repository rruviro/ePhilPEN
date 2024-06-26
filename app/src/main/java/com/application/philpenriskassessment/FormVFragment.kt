package com.application.philpenriskassessment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormVBinding

class FormVFragment : Fragment() {
    private lateinit var binding: FragmentFormVBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormVBinding.inflate(inflater,container,false)

        val age = requireArguments().getInt("age")
        val sex = requireArguments().getString("sex")
        val sbp = binding.pressure.text.toString().toInt()

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_formVFragment_to_formIVFragment)
        }

        val handler = Handler()
        val runnable = Runnable {
            handler.postDelayed(object : Runnable {
                override fun run() {
                    val weightStr = binding.weight.text.toString()
                    val heightStr = binding.height.text.toString()

                    if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                        try {

                            val weight = weightStr.toDouble()
                            val height = heightStr.toDouble()

                            val weightKg = weight * 0.4532592
                            val heightCm = height / 100

                            val calculation = weightKg / (heightCm * heightCm)

                            val category = when (calculation) {
                                in Double.MIN_VALUE..18.5 -> "Underweight"
                                in 18.5..24.9 -> "Normal weight"
                                in 25.0..29.9 -> "Overweight"
                                in 30.0 .. Double.MAX_VALUE -> "Obese"
                                else -> ""
                            }

                            binding.index.setText(category)

                        } catch (e: NumberFormatException) {
                            Toast.makeText(context, "Please enter valid numbers for weight and height.", Toast.LENGTH_SHORT).show()
                        }
                    }

//                    val heightInt = heightStr.toInt()
//                    if (sex == "Female"){
//                        if (heightInt <= 80) {
//                            try {
//
//                            } catch (e: NumberFormatException) {
//                                Toast.makeText(context, "", Toast.LENGTH_SHORT)
//                            }
//                        }
//                    } else {
//                        if (heightInt <= 90) {
//                            try {
//
//                            } catch (e: NumberFormatException) {
//                                Toast.makeText(context, "", Toast.LENGTH_SHORT)
//                            }
//                        }
//                    }

                    handler.postDelayed(this, 0) // Schedule itself again
                }
            },0)
        }
        runnable.run()

        binding.next.setOnClickListener {

            val radioGroupIds = listOf(
                R.id.VradioGroup1, R.id.VradioGroup2, R.id.VradioGroup3, R.id.VradioGroup4
            )

            var anyRadioGroupEmpty = false
            for (radioGroupId in radioGroupIds) {
                val radioGroup = view?.findViewById<RadioGroup>(radioGroupId) ?: continue
                if (radioGroup.checkedRadioButtonId == View.NO_ID) {
                    anyRadioGroupEmpty = true
                    break
                }
            }

            if (anyRadioGroupEmpty) {
                Toast.makeText(context, "Please choose an option for each question.", Toast.LENGTH_SHORT).show()
            } else {
                val allFieldsEmpty = binding.waist.text.isNullOrEmpty() &&
                        binding.height.text.isNullOrEmpty() &&
                        binding.pressure.text.isNullOrEmpty()

                if (allFieldsEmpty) {
                    Toast.makeText(context, "Please fill out all measurements.", Toast.LENGTH_SHORT).show()
                } else {
                    val missingField = when {
                        binding.weight.text.isEmpty() -> "weight"
                        binding.height.text.isEmpty() -> "height"
                        binding.pressure.text.isEmpty() -> "blood pressure"
                        else -> null
                    }
                    if (missingField != null) {
                        val message = "Please enter your $missingField measurement."
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                    } else {
                        if (binding.smoker0.isChecked || binding.smoker1.isChecked) {

                            val childBundle = Bundle()
                            childBundle.putInt("age", age)
                            childBundle.putString("sex", sex)
                            childBundle.putInt("sbp", sbp)
                            childBundle.putString("smoker", "smoker")
                            findNavController().navigate(R.id.action_formVFragment_to_formVIFragment, childBundle)

                        } else {

                            val childBundle = Bundle()
                            childBundle.putInt("age", age)
                            childBundle.putString("sex", sex)
                            childBundle.putInt("sbp", sbp)
                            childBundle.putString("smoker", "non-smoker")
                            findNavController().navigate(R.id.action_formVFragment_to_formVIFragment, childBundle)

                        }
                    }
                }
            }
        }
        return binding.root
    }

}