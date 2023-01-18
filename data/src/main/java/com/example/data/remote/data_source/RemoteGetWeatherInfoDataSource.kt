package com.example.data.remote.data_source

import com.example.data.remote.call_adapter.NetworkState
import com.example.data.remote.model.response.BaseResponse
import com.example.data.remote.model.response.WeatherInfoResponse

interface RemoteGetWeatherInfoDataSource {
    suspend fun getWeatherInfo(
        dataType: String,
        numOfRows: Int,
        pageNo: Int,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ):NetworkState<BaseResponse<WeatherInfoResponse>>
}