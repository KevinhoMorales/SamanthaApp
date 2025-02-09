package com.kevinhomorales.samanthaapp.adapters.customadapter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kevinhomorales.samanthaapp.R
import com.kevinhomorales.samanthaapp.databinding.ActivityCustomAdapterBinding

class CustomAdapterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomAdapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setUpCustomAdapter()
    }

    private fun setUpCustomAdapter() {
        val users = listOf(CustomUser("Kevin", "Morales", 30, listOf(Courses("Android Basic", "Juan"), Courses("iOS Basic", "Carlos"), Courses("KMP Basic", "Laura"))),
            CustomUser("Samantha", "Ávila", 25, listOf(Courses("Jetpack Compose Basic", "Juliana"), Courses("JavaScript Basic", "Gabriela"), Courses("RPA Basic", "Matías"))))
        val adapter = UserAdapter(this, users)
        binding.listId.adapter = adapter
    }
}