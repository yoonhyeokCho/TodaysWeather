package com.example.todaysweather.di

import com.example.data.remote.data_source.RemoteGetWeatherInfoDataSource
import com.example.data.remote.data_source.RemoteGetWeatherInfoDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {

    @Binds
    @Singleton
    fun bindsRemoteGetWeatherDataSource(source: RemoteGetWeatherInfoDataSourceImpl): RemoteGetWeatherInfoDataSource
}