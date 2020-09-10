package com.example.composeweatherapp

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.ColumnScope.weight
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.example.composeweatherapp.history.HistoryViewModel

@Composable
fun HistoryScreen(
    historyViewModel: HistoryViewModel,
    modifier: Modifier = Modifier
) {
    val history: List<LocationWeather> by historyViewModel.weatherHistory.observeAsState(listOf())
    HistoryContent(history = history, modifier)
}

@Composable
fun HistoryContent(
    history: List<LocationWeather>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.background(color = Color.Yellow).fillMaxWidth()) {
        LazyColumnFor(
            items = history,
            modifier = Modifier.weight(1f),
            contentPadding = InnerPadding(top = 8.dp)
        ) { item ->
            Text(text = "${item.locationName} and temperature ${item.temperature}",
                modifier = Modifier.fillParentMaxWidth().padding(start = 10.dp, top = 40.dp)
            )
        }
    }
}