package com.example.composeweatherapp

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeweatherapp.search.SearchViewModel


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
        modifier = modifier.background(color = Color.Yellow).fillMaxWidth()
    ) {
        LocationWeatherSearcher(onSearchEvent = {
            onSearchWeather(it)
        }, modifier = Modifier.background(color = Color.Green))
        LocationWeatherResult(locationWeather = locationWeather)
        Spacer(
            modifier = Modifier.preferredHeight(20.dp).fillMaxWidth()
                .background(color = Color.Cyan)
        )
    }
}

@Composable
fun LocationWeatherSearcher(onSearchEvent: (String) -> Unit, modifier: Modifier) {
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
            modifier = Modifier.padding(12.dp)
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
    Column(modifier = modifier.gravity(Alignment.CenterVertically).background(color = Color.Blue)) {
        Text(text = locationWeather.locationName)
        Text(text = locationWeather.temperature.toString())
    }
}