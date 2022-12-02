package com.example.gamedemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.gamedemo.R

class fragment_about_home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_home, container, false)
        view.findViewById<Button>(R.id.abiButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragment_about_home_to_fragment_about_abi)
        }
        view.findViewById<Button>(R.id.aquilesButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragment_about_home_to_fragment_about_aquiles)
        }
        view.findViewById<Button>(R.id.brunoButton).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragment_about_home_to_fragment_about_bruno)
        }
        return view
    }

}