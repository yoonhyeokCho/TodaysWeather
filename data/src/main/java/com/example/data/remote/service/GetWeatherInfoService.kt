package com.example.data.remote.service

import com.example.data.remote.call_adapter.NetworkState
import com.example.data.remote.model.request.WeatherInfoRequest
import com.example.data.remote.model.response.BaseResponse
import com.example.data.remote.model.response.WeatherInfoResponse
import com.example.todaysweather.data.BuildConfig
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface GetWeatherInfoService {
    @GET("getVilageFcst?serviceKey=${BuildConfig.METEOROLOGICAL_ADMINISTRATION_APP_KEY}")
    suspend fun getWeatherInfo(
    @Body body:WeatherInfoRequest
    ): NetworkState<BaseResponse<WeatherInfoResponse.WEATHER>>
}