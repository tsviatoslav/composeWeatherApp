package com.example.composeweatherapp.core.di

import android.content.Context
import com.example.data.WeatherApi
import com.example.domain.executor.ThreadExecutor
import com.example.domain.repository.WeatherRepository
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, ViewModelFactoryModule::class])
interface AppComponent {
    fun context(): Context

    fun weatherApi(): WeatherApi

    fun weatherRepository(): WeatherRepository

    fun threadExecutor(): ThreadExecutor

}