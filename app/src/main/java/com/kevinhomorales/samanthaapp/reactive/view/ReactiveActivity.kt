package com.kevinhomorales.samanthaapp.reactive.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.kevinhomorales.samanthaapp.R
import com.kevinhomorales.samanthaapp.databinding.ActivityReactiveBinding
import com.kevinhomorales.samanthaapp.reactive.viewmodel.ReactiveViewModel

class ReactiveActivity : AppCompatActivity() {
    lateinit var binding: ActivityReactiveBinding
    lateinit var viewModel: ReactiveViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReactiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        viewModel = ReactiveViewModel()
        binding.nameId.setText(viewModel.name)
        setUpActions()
        observerName()
        observerCounter()
    }

    private fun observerName() {
        viewModel.nombre.observe(this , Observer { nuevoNombre ->
            binding.nameId.text = nuevoNombre
        })
    }

    private fun observerCounter() {
        viewModel.count.observe(this, Observer { newValue ->
            binding.nameId.text = newValue.toString()
        })
    }

    private fun setUpActions() {
        binding.changeButtonId.setOnClickListener {
//            viewModel.changeName("KEVIN")
//            println(viewModel.name)
//            binding.nameId.setText(viewModel.name)

//            viewModel.cambiarNombre("KEVINHO")
            viewModel.increment()
        }
    }
}