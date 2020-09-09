package com.example.domain

import com.example.domain.executor.ThreadExecutor
import com.example.domain.repository.WeatherRepository
import javax.inject.Inject

class SearchWeatherInteractorImpl @Inject constructor(
    private val weatherRepository: WeatherRepository,
    threadExecutor: ThreadExecutor
): SearchWeatherInteractor {
}