package com.tsviatoslav.data.repository

import com.example.data.DataMapper
import com.example.data.WeatherApi
import com.example.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val dataMapper: DataMapper
): WeatherRepository {

}