package com.example.data.remote.data_source

import com.example.data.remote.call_adapter.NetworkState
import com.example.data.remote.model.response.BaseResponse
import com.example.data.remote.model.response.WeatherInfoResponse
import com.example.data.remote.service.GetWeatherInfoService
import retrofit2.Response
import javax.inject.Inject

class RemoteGetWeatherInfoDataSourceImpl @Inject constructor(
    private val weatherInfoService: GetWeatherInfoService
):RemoteGetWeatherInfoDataSource{
    override suspend fun getWeatherInfo(
        dataType: String,
        numOfRows: Int,
        pageNo: Int,
        baseDate: Int,
        baseTime: Int,
        nx: String,
        ny: String
    ): Response<WeatherInfoResponse>{
        return weatherInfoService.getWeatherInfo(dataType,numOfRows,pageNo, baseDate, baseTime, nx, ny)
    }
}