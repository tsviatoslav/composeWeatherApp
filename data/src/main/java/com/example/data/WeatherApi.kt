package com.example.data

import MainWeatherEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET
    fun getWeatherForCity(
        @Query("q") city: String,
        @Query("appid") appid: String
    ) : Single<MainWeatherEntity>
}