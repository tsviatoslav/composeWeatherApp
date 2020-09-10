package com.example.composeweatherapp.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeweatherapp.entity.LocationWeather

class HistoryViewModel : ViewModel() {

    private var _weatherHistory = MutableLiveData(getMockedHistory())
    var weatherHistory: LiveData<List<LocationWeather>> = _weatherHistory

    private fun randomTemp(): Int {
        return (-10..30).random()
    }

    private fun getMockedHistory() : List<LocationWeather> {
        return listOf(
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
    }
}