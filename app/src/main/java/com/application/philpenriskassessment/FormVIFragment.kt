package com.application.philpenriskassessment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentFormViBinding
import java.util.Calendar

class FormVIFragment : Fragment() {
    private lateinit var binding: FragmentFormViBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormViBinding.inflate(inflater,container,false)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_formVIFragment_to_formVFragment)
        }

        binding.bsDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this.requireContext(), R.style.DatePickerDialogTheme,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val monthString = String.format("%02d", selectedMonth + 1)
                    val dayString = String.format("%02d", selectedDayOfMonth)
                    val formattedDate = "$dayString-$monthString-$selectedYear"
                    binding.bsDate.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        binding.lpDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this.requireContext(), R.style.DatePickerDialogTheme,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val monthString = String.format("%02d", selectedMonth + 1)
                    val dayString = String.format("%02d", selectedDayOfMonth)
                    val formattedDate = "$dayString-$monthString-$selectedYear"
                    binding.lpDate.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        binding.pDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this.requireContext(), R.style.DatePickerDialogTheme,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val monthString = String.format("%02d", selectedMonth + 1)
                    val dayString = String.format("%02d", selectedDayOfMonth)
                    val formattedDate = "$dayString-$monthString-$selectedYear"
                    binding.pDate.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        binding.kDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this.requireContext(), R.style.DatePickerDialogTheme,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val monthString = String.format("%02d", selectedMonth + 1)
                    val dayString = String.format("%02d", selectedDayOfMonth)
                    val formattedDate = "$dayString-$monthString-$selectedYear"
                    binding.kDate.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        binding.lpDate.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this.requireContext(), R.style.DatePickerDialogTheme,
                { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val monthString = String.format("%02d", selectedMonth + 1)
                    val dayString = String.format("%02d", selectedDayOfMonth)
                    val formattedDate = "$dayString-$monthString-$selectedYear"
                    binding.lpDate.setText(formattedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        binding.next.setOnClickListener {

            val radioGroupIds = listOf(
                R.id.VIradioGroup1, R.id.VIradioGroup2
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
                val allFieldsEmpty = binding.fbs.text.isNullOrEmpty() &&
                        binding.rbs.text.isNullOrEmpty() &&
                        binding.cholesterol.text.isNullOrEmpty() &&
                        binding.hdl.text.isNullOrEmpty() &&
                        binding.ldl.text.isNullOrEmpty() &&
                        binding.vldl.text.isNullOrEmpty() &&
                        binding.triglyceride.text.isNullOrEmpty() &&
                        binding.protein.text.isNullOrEmpty() &&
                        binding.ketones.text.isNullOrEmpty() &&
                        binding.bsDate.text.isNullOrEmpty() &&
                        binding.kDate.text.isNullOrEmpty() &&
                        binding.lpDate.text.isNullOrEmpty() &&
                        binding.pDate.text.isNullOrEmpty()



                if (allFieldsEmpty) {
                    Toast.makeText(context, "Please fill out all measurements.", Toast.LENGTH_SHORT).show()
                } else {
                    val missingField = when {
                        binding.fbs.text.isEmpty() -> "fbs"
                        binding.rbs.text.isEmpty() -> "rbs"
                        binding.cholesterol.text.isEmpty() -> "cholesterol"
                        binding.hdl.text.isEmpty() -> "hdl"
                        binding.ldl.text.isEmpty() -> "ldl"
                        binding.vldl.text.isEmpty() -> "vldl"
                        binding.triglyceride.text.isEmpty() -> "triglyceride"
                        binding.protein.text.isEmpty() -> "protein"
                        binding.ketones.text.isEmpty() -> "ketones"
                        binding.bsDate.text.isEmpty() -> "Blood Sugar Date"
                        binding.kDate.text.isEmpty() -> "Ketones pressure"
                        binding.lpDate.text.isEmpty() -> "Lipid Profile Date"
                        binding.pDate.text.isEmpty() -> "Protein Date"
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
                        val cholesterol = binding.cholesterol.text.toString()

                        val childBundle = Bundle()
                        childBundle.putString("age", age)
                        childBundle.putString("sex", sex)
                        childBundle.putString("sbp", sbp)
                        childBundle.putString("smoker", smoker)
                        childBundle.putString("cholesterol", cholesterol)

                        findNavController().navigate(R.id.action_formVIFragment_to_formVIIFragment, childBundle)
                    }
                }
            }

        }

        return binding.root
    }

}