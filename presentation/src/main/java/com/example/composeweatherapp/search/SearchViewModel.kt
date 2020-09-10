package com.example.composeweatherapp.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeweatherapp.LocationWeather

class SearchViewModel: ViewModel() {


    // state: weather for location
    private var _locationWeather = MutableLiveData(LocationWeather())
    var locationWeather: LiveData<LocationWeather> = _locationWeather

    //event: request weather for location
    fun searchWeather(city: String) {
        val item = LocationWeather(city, 10.0f)
        _locationWeather.value = item
    }
}