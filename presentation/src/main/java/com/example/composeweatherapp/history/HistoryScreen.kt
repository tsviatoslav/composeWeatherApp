package com.example.composeweatherapp.history

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composeweatherapp.entity.LocationWeather

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
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Mocked search history, enjoy!",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp)
        )
        LazyColumnFor(
            items = history,
            modifier = Modifier.weight(1f),
            contentPadding = InnerPadding(top = 16.dp)
        ) { item ->
            Text(text = "${item.locationName} and temperature ${item.temperature}",
                modifier = Modifier.fillParentMaxWidth().padding(start = 10.dp, top = 10.dp)
            )
        }
    }
}