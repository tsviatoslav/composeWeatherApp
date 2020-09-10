package com.example.composeweatherapp


import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composeweatherapp.history.HistoryScreen
import com.example.composeweatherapp.history.HistoryViewModel
import com.example.composeweatherapp.search.SearchScreen
import com.example.composeweatherapp.search.SearchViewModel
import com.example.composeweatherapp.ui.typography

@Composable
fun WeatherScreen(
    screenState: ScreenState,
    onNavigate: (ScreenState.Screen) -> Unit,
    searchViewModel: SearchViewModel,
    historyViewModel: HistoryViewModel,
) {
    Column {
        TabsPanel(screenState = screenState, onNavigate = onNavigate)
        Surface(Modifier.background(color = Color.LightGray)) {
            when (screenState.state) {
                ScreenState.Screen.SEARCH -> {
                    SearchScreen(searchViewModel = searchViewModel)
                }
                ScreenState.Screen.HISTORY -> {
                    HistoryScreen(historyViewModel = historyViewModel)
                }
            }
        }
    }
}

