package com.kevinhomorales.samanthaapp.profile.view

import android.os.Bundle
import android.widget.Toast
import com.kevinhomorales.samanthaapp.databinding.ActivityProfileBinding
import com.kevinhomorales.samanthaapp.main.view.MainActivity

class ProfileActivity : MainActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setUpActions()
    }

    private fun setUpActions() {
        binding.exitIconId.setOnClickListener {
            Toast.makeText(this, "Ha salido con éxito", Toast.LENGTH_SHORT).show()
        }
    }
}