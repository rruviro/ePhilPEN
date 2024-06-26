package com.application.philpenriskassessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormIiiBinding

class FormIIIFragment : Fragment() {
    private lateinit var binding: FragmentFormIiiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormIiiBinding.inflate(inflater,container,false)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_formIIIFragment_to_formIIFragment)
        }

        binding.next.setOnClickListener {

            val radioGroupIds = listOf(
                R.id.IIIradioGroup1, R.id.IIIradioGroup2, R.id.IIIradioGroup3, R.id.IIIradioGroup4,
                R.id.IIIradioGroup5, R.id.IIIradioGroup6, R.id.IIIradioGroup7, R.id.IIIradioGroup8,
                R.id.IIIradioGroup9, R.id.IIIradioGroup10, R.id.IIIradioGroup11, R.id.IIIradioGroup12
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

                val age = requireArguments().getInt("age")
                val sex = requireArguments().getString("sex")

                val childBundle = Bundle()
                childBundle.putInt("age", age)
                childBundle.putString("sex", sex)
                findNavController().navigate(R.id.action_formIIIFragment_to_formIVFragment, childBundle)

            }

        }

        return binding.root
    }

}