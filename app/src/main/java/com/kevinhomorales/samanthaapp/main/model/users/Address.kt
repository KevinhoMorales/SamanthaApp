package com.kevinhomorales.samanthaapp.main.model.users

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)