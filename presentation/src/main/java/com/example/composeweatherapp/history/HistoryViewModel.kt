package com.example.composeweatherapp.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeweatherapp.entity.LocationWeather

class HistoryViewModel : ViewModel() {

    // state: weather history
//    private var _weatherHistory = MutableLiveData(listOf<LocationWeather>())

    private fun randomTemp(): Int {
        return (-10..30).random()
    }

    //Todo remove this stub data
    private var _weatherHistory = MutableLiveData(
        listOf(
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
            LocationWeather("Location 1", randomTemp()),
            LocationWeather("Location 2", randomTemp()),
            LocationWeather("Location 3", randomTemp()),
            LocationWeather("Location 4", randomTemp()),
            LocationWeather("Location 5", randomTemp()),
        )
    )
    var weatherHistory: LiveData<List<LocationWeather>> = _weatherHistory
}