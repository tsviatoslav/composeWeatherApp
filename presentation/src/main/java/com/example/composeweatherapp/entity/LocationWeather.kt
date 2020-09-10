package com.example.composeweatherapp.entity

data class LocationWeather(
    var locationName: String = "",
    var temperature: Int = (-10..35).random()
)