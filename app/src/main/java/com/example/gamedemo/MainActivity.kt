package com.example.gamedemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gamedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aboutButton.setOnClickListener() { goToActivity(AboutActivity()) }
        binding.sendButton.setOnClickListener() { goToActivityDataTransfer(GameActivity()) }
    }

    private fun goToActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }

    private fun goToActivityDataTransfer(activity: Activity) {
        var nickName = binding.txtInputNameText.text.toString()

        if(nickName == "")
            nickName = "Joao sem nome"

        val intent = Intent(this, activity::class.java)
        intent.putExtra("nickName", nickName)
        startActivity(intent)
    }

}


