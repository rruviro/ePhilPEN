package com.application.philpenriskassessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
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
            val radioGroupIds = listOf(
                R.id.VIIradioGroup1, R.id.VIIradioGroup2, R.id.VIIradioGroup3
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
                Toast.makeText(
                    context,
                    "Please choose an option for each question.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val allFieldsEmpty = binding.df.text.isNullOrEmpty() &&
                        binding.date.text.isNullOrEmpty() &&
                        binding.remarks.text.isNullOrEmpty()


                if (allFieldsEmpty) {
                    Toast.makeText(context, "Please fill out all measurements.", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val missingField = when {
                        binding.df.text.isEmpty() -> "date of follow-up"
                        binding.date.text.isEmpty() -> "date"
                        binding.remarks.text.isEmpty() -> "remarks"
                        else -> null
                    }
                    if (missingField != null) {
                        val message = "Please enter your $missingField measurement."
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                    } else {
                        val age = requireArguments().getString("age")
                        val sex = requireArguments().getString("sex")
                        val sbp = requireArguments().getString("sbp")
                        val smoker = requireArguments().getString("smoker")
                        val cholesterol = requireArguments().getString("cholesterol")

                        val childBundle = Bundle()
                        childBundle.putString("age", age)
                        childBundle.putString("sex", sex)
                        childBundle.putString("sbp", sbp)
                        childBundle.putString("smoker", smoker)
                        childBundle.putString("cholesterol", cholesterol)

                        findNavController().navigate(
                            R.id.action_formVIIFragment_to_resultFragment,
                            childBundle
                        )
                    }
                }
            }
        }

        return binding.root

    }

}