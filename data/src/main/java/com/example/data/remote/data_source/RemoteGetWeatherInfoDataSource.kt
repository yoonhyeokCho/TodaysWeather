package com.example.data.remote.data_source

import com.example.data.remote.call_adapter.NetworkState
import com.example.data.remote.model.response.BaseResponse
import com.example.data.remote.model.response.WeatherInfoResponse
import retrofit2.Response
import retrofit2.http.Query

interface RemoteGetWeatherInfoDataSource {
    suspend fun getWeatherInfo(
        dataType: String,
        numOfRows: Int,
        pageNo: Int,
        baseDate: Int,
        baseTime: Int,
        nx: String,
        ny: String
    ):Response<WeatherInfoResponse>
}