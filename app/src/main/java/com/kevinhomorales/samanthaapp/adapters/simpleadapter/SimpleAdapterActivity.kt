package com.kevinhomorales.samanthaapp.adapters.simpleadapter

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kevinhomorales.samanthaapp.R
import com.kevinhomorales.samanthaapp.databinding.ActivitySimpleAdapterBinding

class SimpleAdapterActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleAdapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setUpList()
    }

    private fun setUpList() {
        val names = listOf("Kevin", "Samantha", "Antonio", "Jorge", "María", "Ana", "Carlos", "Diana", "Luis")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_2, names)
        binding.listId.adapter = adapter
    }
}