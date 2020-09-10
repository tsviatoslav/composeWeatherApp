package com.example.composeweatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {

    private var _screenState = MutableLiveData(ScreenState())
    var screenState: LiveData<ScreenState> = _screenState

    fun navigateTo(state: ScreenState.Screen) {
        _screenState.value = ScreenState(state)
    }

}