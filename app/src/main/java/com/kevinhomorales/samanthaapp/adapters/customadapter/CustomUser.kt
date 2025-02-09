package com.kevinhomorales.samanthaapp.adapters.customadapter

data class CustomUser(
    val name: String,
    val lastName: String,
    val age: Int,
    val courses: List<Courses>
)

data class Courses(
    val name: String,
    val teacher: String
)