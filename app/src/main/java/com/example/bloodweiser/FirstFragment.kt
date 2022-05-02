package com.example.bloodweiser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val button1: Button = view.findViewById(R.id.button1) as Button
        val button2: Button = view.findViewById(R.id.button2) as Button
        val button3: Button = view.findViewById(R.id.button3) as Button

        button2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
        }

        button1.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        button3.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_fourthFragment)
        }

        return view
    }
}