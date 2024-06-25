package com.application.philpenriskassessment

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.application.philpenriskassessment.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater,container,false)
        var timer = object : CountDownTimer(3000,20){
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }
        timer.start()
        return binding.root
    }

}