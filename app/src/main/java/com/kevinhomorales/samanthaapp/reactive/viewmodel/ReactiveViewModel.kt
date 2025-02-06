package com.kevinhomorales.samanthaapp.reactive.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ReactiveViewModel {
    var name = "SAMANTHA"

    private val _nombre = MutableLiveData<String>()
    val nombre: LiveData<String> get() = _nombre

    fun changeName(newName: String) {
        name = newName
    }

    fun cambiarNombre(nuevoNombre: String) {
        _nombre.value = nuevoNombre
    }

    private val _count = MutableLiveData(0)
    val count: LiveData<Int> get() = _count

    fun increment() {
        _count.value = (_count.value ?: 0) + 1
    }
}