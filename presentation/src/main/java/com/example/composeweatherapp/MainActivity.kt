package com.example.composeweatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.example.composeweatherapp.history.HistoryViewModel
import com.example.composeweatherapp.search.SearchViewModel
import com.example.composeweatherapp.ui.ComposeWeatherAppTheme


class MainActivity : AppCompatActivity() {

    val weatherViewModel by viewModels<WeatherViewModel>()
    val searchViewModel by viewModels<SearchViewModel>()
    val historyViewModel by viewModels<HistoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWeatherAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    WeatherActivityScreen(
                        weatherViewModel = weatherViewModel,
                        searchViewModel = searchViewModel,
                        historyViewModel = historyViewModel
                    )
                }
            }
        }
    }
}

@Composable
private fun WeatherActivityScreen(
    weatherViewModel: WeatherViewModel,
    searchViewModel: SearchViewModel,
    historyViewModel: HistoryViewModel
) {
    val screenState: ScreenState by weatherViewModel.screenState.observeAsState(
        weatherViewModel.screenState.value!!
    )
    WeatherScreen(
        screenState = screenState,
        onNavigate = {
            weatherViewModel.navigateTo(it)
        },
        searchViewModel = searchViewModel,
        historyViewModel = historyViewModel
    )

}
