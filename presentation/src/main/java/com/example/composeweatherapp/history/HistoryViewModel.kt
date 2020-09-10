package com.example.composeweatherapp.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeweatherapp.LocationWeather

class HistoryViewModel: ViewModel() {

    // state: weather history
//    private var _weatherHistory = MutableLiveData(listOf<LocationWeather>())

   //Todo remove this stub data
    private var _weatherHistory = MutableLiveData(listOf(
        LocationWeather("Location 1", 10.0f),
        LocationWeather("Location 2", 20.0f),
        LocationWeather("Location 3", 30.0f),
        LocationWeather("Location 4", 40.0f),
        LocationWeather("Location 5", 50.0f),
    ))
    var weatherHistory: LiveData<List<LocationWeather>> = _weatherHistory
}