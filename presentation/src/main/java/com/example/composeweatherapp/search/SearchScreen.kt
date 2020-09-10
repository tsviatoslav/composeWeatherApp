package com.example.composeweatherapp.search

import android.widget.Space
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.layout.RowScope.weight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composeweatherapp.entity.LocationWeather


@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier
) {
    val locationWeather: LocationWeather by searchViewModel.locationWeather.observeAsState(
        LocationWeather()
    )
    val onSearchWeather: (String) -> Unit = {
        searchViewModel.searchWeather(it)
    }

    SearchContent(locationWeather = locationWeather, onSearchWeather = onSearchWeather)

}

@Composable
fun SearchContent(
    locationWeather: LocationWeather,
    onSearchWeather: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Please enter city name for search",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp)
        )
        LocationWeatherSearcher(onSearchEvent = {
            onSearchWeather(it)
        })
        if (locationWeather.locationName.isNotEmpty()) {
            LocationWeatherResult(locationWeather = locationWeather, modifier = Modifier.weight(3f))
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun LocationWeatherSearcher(onSearchEvent: (String) -> Unit, modifier: Modifier = Modifier) {
    val searchText = remember { mutableStateOf("") }
    val submit = {
        onSearchEvent(searchText.value)
        searchText.value = ""
    }

    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp).fillMaxWidth()
    ) {
        SearchInputText(
            text = searchText.value, onTextChange = {
                searchText.value = it
            },
            modifier = Modifier.padding(12.dp).weight(3f)
        )
        SearchApplyButton(
            onClick = submit, text = "Search",
            modifier = Modifier.gravity(Alignment.CenterVertically),
            enabled = searchText.value.isNotBlank()
        )
    }
}

@Composable
fun SearchInputText(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) = TextField(
    value = text,
    onValueChange = {
        onTextChange(it)
    },
    label = { /* no label */ },
    backgroundColor = Color.Transparent,
    modifier = modifier
)

@Composable
fun SearchApplyButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        elevation = 0.dp,
        modifier = modifier
    ) {
        Text(text)
    }
}

@Composable
fun LocationWeatherResult(
    locationWeather: LocationWeather,
    modifier: Modifier = Modifier
) {
    Column(horizontalGravity = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = "Such a lovely weather in ${locationWeather.locationName}!",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Temperature is ${locationWeather.temperature} ℃",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            textAlign = TextAlign.Center
        )
    }
}