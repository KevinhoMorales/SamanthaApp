package com.kevinhomorales.samanthaapp.sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kevinhomorales.samanthaapp.networkmanager.RetrofitService
import com.kevinhomorales.samanthaapp.sample.viewmodel.SampleViewModel

class SampleViewModelFactory(private val service: RetrofitService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SampleViewModel::class.java)) {
            return SampleViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}