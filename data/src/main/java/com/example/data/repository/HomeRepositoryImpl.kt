package com.example.data.repository

import android.util.Log
import com.example.data.remote.call_adapter.NetworkState
import com.example.data.remote.data_source.RemoteGetWeatherInfoDataSource
import com.example.data.remote.service.GetWeatherInfoService
import com.example.domain.entity.response.DomainWeatherInfoResponse
import com.example.domain.repository.HomeRepository
import timber.log.Timber
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteGetWeatherInfoDataSource: RemoteGetWeatherInfoDataSource
) : HomeRepository {
    override suspend fun getWeatherInfo(
        dataType: String,
        numOfRows: Int,
        pageNo: Int,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): Result<DomainWeatherInfoResponse> {
        when (val response = remoteGetWeatherInfoDataSource.getWeatherInfo(
            dataType,
            numOfRows,
            pageNo,
            baseDate,
            baseTime,
            nx,
            ny
        )) {
            is NetworkState.Success -> return Result.success(
                DomainWeatherInfoResponse(
                    rainType = response.body.data.rainType,
                    humidity = response.body.data.humidity,
                    sky = response.body.data.sky,
                    temp = response.body.data.temp,
                    fcstTime = response.body.data.fcstTime
                )
            )
            is NetworkState.NetworkError -> Timber.d(
                response.error
            )
            is NetworkState.UnknownError -> Timber.d(
                response.t
            )
        }
        return Result.failure(IllegalStateException("NetworkError or UnKnownError please check timber"))
    }
}