package com.example.composeweatherapp.core.di

import com.example.composeweatherapp.core.di.scopes.WeatherScope
import com.example.domain.SearchWeatherInteractor
import com.example.domain.SearchWeatherInteractorImpl
import com.example.domain.executor.ThreadExecutor
import com.example.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides

@Module
class SearchWeatherModule {

    @WeatherScope
    @Provides
    fun provideInteractor(weatherRepository: WeatherRepository,
    executor: ThreadExecutor): SearchWeatherInteractor =
        SearchWeatherInteractorImpl(weatherRepository, executor)
}