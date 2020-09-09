package com.example.composeweatherapp.core.di

import androidx.lifecycle.ViewModel
import com.example.composeweatherapp.HistoryWeatherViewModel
import com.example.composeweatherapp.SearchWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WeatherViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SearchWeatherViewModel::class)
    abstract fun bindSearchWeatherViewModel(searchWeatherViewModel: SearchWeatherViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryWeatherViewModel::class)
    abstract fun bindHistoryWeatherViewModel(historyWeatherViewModel: HistoryWeatherViewModel): ViewModel

}