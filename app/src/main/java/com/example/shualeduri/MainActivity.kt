package com.example.shualeduri

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shualeduri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)

        binding.logIn.setOnClickListener {
            val name = binding.nameEditTxt.text.toString()
            if(name.isEmpty()){
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, SecondActivity::class.java)
                sharedPreferences.edit().putString("user_name", binding.nameEditTxt.text.toString()).apply()
                startActivity(intent)
            }
        }
        binding.profileIcon.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}