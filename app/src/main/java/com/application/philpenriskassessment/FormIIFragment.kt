package com.application.philpenriskassessment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormIiBinding

class FormIIFragment : Fragment() {
    private lateinit var binding: FragmentFormIiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFormIiBinding.inflate(inflater,container,false)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_formIIFragment_to_formFragment)
        }

        binding.next.setOnClickListener {
            if (binding.radioo1.isChecked && binding.radioo2.isChecked && binding.radioo3.isChecked && binding.radioo4.isChecked
                && binding.radioo5.isChecked && binding.radioo6.isChecked && binding.radioo7.isChecked && binding.radioo8.isChecked
                && binding.radioo9.isChecked && binding.radioo10.isChecked && binding.radioo11.isChecked && binding.radioo12.isChecked && binding.radioo13.isChecked) {
                val age = arguments?.getString("age").toString()
                val sex = arguments?.getString("sex")

                val childBundle = Bundle()
                childBundle.putString("age", age)
                childBundle.putString("sex", sex)
                findNavController().navigate(R.id.action_formIIFragment_to_formIIIFragment, childBundle)
            } else {
                Toast.makeText(context, "you're required to fill out all question.", Toast.LENGTH_SHORT).show()
            }
        }

        auto()

        return binding.root

    }

    fun auto() {

        binding.radioGroup1.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio1.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup2.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio2.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup3.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio3.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup4.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio4.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup5.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio5.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup6.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio6.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup7.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio7.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup8.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio8.isChecked) {
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup9.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio9.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup10.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio10.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup11.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio11.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup12.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio12.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

        binding.radioGroup13.setOnCheckedChangeListener  { _, _ ->
            if (binding.radio13.isChecked) {
                
                findNavController().navigate(R.id.action_formIIFragment_to_referFragment)
            }
        }

    }

}