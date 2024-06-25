package com.application.philpenriskassessment

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.view.marginTop

class AgeAdapter(context: Context, resource: Int, private val ageOptions: Array<String>) :
    ArrayAdapter<String>(context, resource, ageOptions) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1) 
        val resources = context.resources
        val largeTextSize = resources.getDimension(R.dimen.text_size_large)
        if (position == 0) {
            textView.text = "Select Age"  
            textView.textSize = largeTextSize
            textView.setTextColor(Color.GRAY)
        } else {
            textView.textSize = 13f
            textView.text = ageOptions[position]
        }
        textView.setTextColor(Color.BLACK) 
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val resources = context.resources
        val largeTextSize = resources.getDimension(R.dimen.text_size_large)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.textSize = largeTextSize
        textView.text = ageOptions[position]  
        textView.setTextColor(Color.WHITE) 
        return view
    }
}

class GenderAdapter(context: Context, resource: Int, private val genderOption: Array<String>) :
    ArrayAdapter<String>(context, resource, genderOption) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1) 
        val resources = context.resources
        val largeTextSize = resources.getDimension(R.dimen.text_size_large)
        if (position == 0) {
            textView.text = "Select Gender" 
            textView.textSize = largeTextSize
            textView.setTextColor(Color.GRAY)
        } else {
            textView.textSize = 13f
            textView.text = genderOption[position] 
        }
        textView.setTextColor(Color.BLACK) 
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val resources = context.resources
        val largeTextSize = resources.getDimension(R.dimen.text_size_large)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.textSize = largeTextSize
        textView.text = genderOption[position] 
        textView.setTextColor(Color.WHITE)
        return view
    }

}

class CivilAdapter(context: Context, resource: Int, private val civilOption: Array<String>) :
    ArrayAdapter<String>(context, resource, civilOption) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1) 
        val resources = context.resources
        val largeTextSize = resources.getDimension(R.dimen.text_size_large)
        if (position == 0) {
            textView.text = "Select Civil" 
            textView.textSize = largeTextSize
            textView.setTextColor(Color.GRAY) 
        } else {
            textView.textSize = 13f
            textView.text = civilOption[position]
        }
        textView.setTextColor(Color.BLACK)
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val resources = context.resources
        val largeTextSize = resources.getDimension(R.dimen.text_size_large)
        val textView = view.findViewById<TextView>(android.R.id.text1) 
        textView.textSize = largeTextSize
        textView.text = civilOption[position] 
        textView.setTextColor(Color.WHITE)
        return view
    }
}

class ReligionAdapter(context: Context, resource: Int, private val religionOption: Array<String>) :
    ArrayAdapter<String>(context, resource, religionOption) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        val resources = context.resources
        val largeTextSize = resources.getDimension(R.dimen.text_size_large)
        if (position == 0) {
            textView.text = "Select Religion"
            textView.textSize = largeTextSize
            textView.setTextColor(Color.GRAY) 
        } else {
            textView.textSize = 13f
            textView.text = religionOption[position]
        }
        textView.setTextColor(Color.BLACK)
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val resources = context.resources
        val largeTextSize = resources.getDimension(R.dimen.text_size_large)
        val textView = view.findViewById<TextView>(android.R.id.text1) 
        textView.textSize = largeTextSize
        textView.text = religionOption[position] 
        textView.setTextColor(Color.WHITE)
        return view
    }
}