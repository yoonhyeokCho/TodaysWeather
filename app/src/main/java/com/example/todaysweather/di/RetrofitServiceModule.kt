package com.example.todaysweather.di

import com.example.data.remote.service.GetWeatherInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitServiceModule {
    @Provides
    @Singleton
    fun provideGetWeatherService(retrofit: Retrofit): GetWeatherInfoService=
        retrofit.create(GetWeatherInfoService::class.java)
}