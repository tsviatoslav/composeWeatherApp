package com.example.composeweatherapp.core.di

import android.app.Application
import android.content.Context
import com.example.composeweatherapp.core.executor.BaseExecutor
import com.example.data.DataMapper
import com.example.data.WeatherApi
import com.example.domain.executor.ThreadExecutor
import com.example.domain.repository.WeatherRepository
import com.tsviatoslav.data.ServiceBuilder
import com.tsviatoslav.data.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideAppContext(): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideWeatherApi(): WeatherApi = ServiceBuilder.buildService(
        WeatherApi::class.java)

    @Singleton
    @Provides
    fun provideRepository(weatherApi: WeatherApi, dataMapper: DataMapper): WeatherRepository =
        WeatherRepositoryImpl(weatherApi, dataMapper)

    @Singleton
    @Provides
    fun provideExecutor(): ThreadExecutor =
        BaseExecutor()
}