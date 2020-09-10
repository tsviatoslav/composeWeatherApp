package com.example.composeweatherapp

data class ScreenState(var state: Screen = Screen.SEARCH) {

    enum class Screen {
        SEARCH, HISTORY
    }
}