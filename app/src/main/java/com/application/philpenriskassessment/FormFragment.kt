package com.application.philpenriskassessment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormIBinding

class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormIBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormIBinding.inflate(inflater,container,false)

        val ageOptions = arrayOf("Select Age", "40", "50", "60", "70")
        val ageAdapter = AgeAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, ageOptions)
        binding.age.adapter = ageAdapter

        val genderOptions = arrayOf("Select Gender", "Male", "Female")
        val genderAdapter = GenderAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, genderOptions)
        binding.sex.adapter = genderAdapter

        val civilOptions = arrayOf("Select Civil", "Married", "Single")
        val civilAdapter = CivilAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, civilOptions)
        binding. civil.adapter = civilAdapter

        val religionOptions = arrayOf (
            "Select Religion",
            "Christianity",
            "Islam",
            "Judaism",
            "Druze",
            "Baháʼí Faith",

            "Hinduism",
            "Buddhism",
            "Sikhism",
            "Jainism",

            "Confucianism",
            "Taoism",
            "Shinto",

            "Animism",
            "Ancestor veneration",

            "Native American religions",
            "Australian Aboriginal religions",

            "Scientology",
            "Mormonism",
            "Jehovah's Witnesses",

            "Unitarian Universalism",
            "Rastafari",
            "Tenrikyo",
            "Cao Đài"
        )

        val religionAdapter = ReligionAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, religionOptions)
        binding.religion.adapter = religionAdapter

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_formFragment_to_homeFragment)
        }

        binding.editTextDate.setOnClickListener {
            showDatePicker()
        }

        binding.birth.setOnClickListener {
            showDatePicker()
        }

        binding.next.setOnClickListener {

            if (!validateFormFields()) {
                Toast.makeText(context, "Please fill out all required fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                val age = binding.age.selectedItem as? String
                val sex = binding.sex.selectedItem as? String

                val bundle = Bundle()
                bundle.putString("age", age)
                bundle.putString("sex", sex)
                findNavController().navigate(R.id.action_formFragment_to_formIIFragment, bundle)
            }
        }

        return binding.root
    }

    private fun showDatePicker() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(R.layout.date_picker).
        show()
    }

    private fun validateFormFields(): Boolean {

        val requiredViews = listOf(
            binding.age, binding.sex, binding.civil, binding.religion,
            binding.healthFaculty, binding.editTextDate, binding.patientName,
            binding.phic, binding.birth, binding.contact, binding.address
        )

        // Check for empty fields or default hint selections in Spinners
        for (view in requiredViews) {
            if (view is EditText) {
                if (view.text?.toString()?.trim()!!.isEmpty()) {
                    return false // Empty EditText
                }
            } else if (view is Spinner) {
                if (view.selectedItemPosition == 0) {
                    return false // Default hint selected in Spinner
                }
            }
        }

        return true // All fields are valid
    }

}