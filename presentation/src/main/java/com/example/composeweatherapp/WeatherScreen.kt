package com.example.composeweatherapp


import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeweatherapp.history.HistoryViewModel
import com.example.composeweatherapp.search.SearchViewModel

@Composable
fun WeatherScreen(
    screenState: ScreenState,
    onNavigate: (ScreenState.Screen) -> Unit,
    searchViewModel: SearchViewModel,
    historyViewModel: HistoryViewModel,
) {
    Column {
        Row {
            Button(onClick = {
                onNavigate(ScreenState.Screen.SEARCH)
            }, modifier = Modifier.padding(20.dp)) {
                Text("SEARCH")
            }
            Button(onClick = {
                onNavigate(ScreenState.Screen.HISTORY)
            }, modifier = Modifier.padding(20.dp)) {
                Text("HISTORY")
            }
        }
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

