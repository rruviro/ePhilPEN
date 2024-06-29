package com.application.philpenriskassessment

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormIBinding
import java.util.Calendar

class FormFragment : Fragment() {
    private lateinit var binding: FragmentFormIBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormIBinding.inflate(inflater,container,false)

        val ageOptions = arrayOf("Select Age", "40->49", "50->59", "60->69", "70->79")
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
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this.requireContext(), R.style.DatePickerDialogTheme,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val monthString = String.format("%02d", selectedMonth + 1)
                    val dayString = String.format("%02d", selectedDayOfMonth)
                    val formattedDate = "$dayString-$monthString-$selectedYear"
                    binding.editTextDate.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        binding.birth.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this.requireContext(), R.style.DatePickerDialogTheme,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val monthString = String.format("%02d", selectedMonth + 1)
                    val dayString = String.format("%02d", selectedDayOfMonth)
                    val formattedDate = "$dayString-$monthString-$selectedYear"
                    binding.birth.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        binding.next.setOnClickListener {

            if (!validateFormFields()) {
                Toast.makeText(context, "Please fill out all required fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {

                if ((binding.Employed.isChecked || binding.Unemployed.isChecked || binding.student.isChecked || binding.self.isChecked) && binding.ip.isChecked || binding.nonIp.isChecked) {
                    val age = binding.age.selectedItem as? String
                    val sex = binding.sex.selectedItem as? String

                    val bundle = Bundle()
                    when (age) {
                        "40->49" -> {
                            bundle.putString("age", "40")
                            bundle.putString("sex", sex)
                            findNavController().navigate(R.id.action_formFragment_to_formIIFragment, bundle)
                        }
                        "50->59" -> {
                            bundle.putString("age", "50")
                            bundle.putString("sex", sex)
                            findNavController().navigate(R.id.action_formFragment_to_formIIFragment, bundle)
                        }
                        "60->69" -> {
                            bundle.putString("age", "60")
                            bundle.putString("sex", sex)
                            findNavController().navigate(R.id.action_formFragment_to_formIIFragment, bundle)
                        }
                        "70->79" -> {
                            bundle.putString("age", "70")
                            bundle.putString("sex", sex)
                            findNavController().navigate(R.id.action_formFragment_to_formIIFragment, bundle)
                        }
                    }

                } else {
                    Toast.makeText(context, "Please fill out all required fields.", Toast.LENGTH_SHORT).show()
                }

            }
        }

        return binding.root
    }

    private fun validateFormFields(): Boolean {

        val requiredViews = listOf(
            binding.age, binding.sex, binding.civil, binding.religion,
            binding.healthFaculty, binding.editTextDate, binding.patientName,
            binding.phic, binding.birth, binding.contact, binding.address, binding.ethnicity
        )

        for (view in requiredViews) {
            if (view is EditText) {
                if (view.text?.toString()?.trim()!!.isEmpty()) {
                    return false
                }
            } else if (view is Spinner) {
                if (view.selectedItemPosition == 0) {
                    return false
                }
            }
        }

        return true
    }

}