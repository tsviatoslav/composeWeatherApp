package com.example.composeweatherapp.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeweatherapp.entity.LocationWeather

class SearchViewModel: ViewModel() {


    // state: weather for location
    private var _locationWeather = MutableLiveData(LocationWeather())
    var locationWeather: LiveData<LocationWeather> = _locationWeather

    //event: request weather for location
    fun searchWeather(city: String) {
        val item = LocationWeather(city, (-10..30).random())
        _locationWeather.value = item
    }
}