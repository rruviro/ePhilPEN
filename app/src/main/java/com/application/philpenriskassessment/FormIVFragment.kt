package com.application.philpenriskassessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormIvBinding

class FormIVFragment : Fragment() {
    private lateinit var binding: FragmentFormIvBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormIvBinding.inflate(inflater,container,false)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_formIVFragment_to_formIIIFragment)
        }

        binding.next.setOnClickListener {

            val radioGroupIds = listOf(
                R.id.IVradioGroup1, R.id.IVradioGroup2, R.id.IVradioGroup3, R.id.IVradioGroup4,
                R.id.IVradioGroup5, R.id.IVradioGroup6, R.id.IVradioGroup7, R.id.IVradioGroup8,
                R.id.IVradioGroup9, R.id.IVradioGroup10, R.id.IVradioGroup11
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

                val age = requireArguments().getString("age")
                val sex = requireArguments().getString("sex")

                val childBundle = Bundle()
                childBundle.putString("age", age)
                childBundle.putString("sex", sex)
                findNavController().navigate(R.id.action_formIVFragment_to_formVFragment, childBundle)

            }

        }

        return binding.root
    }

}