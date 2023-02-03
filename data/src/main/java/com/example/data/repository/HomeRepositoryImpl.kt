package com.example.data.repository

import com.example.data.remote.call_adapter.NetworkState
import com.example.data.remote.data_source.RemoteGetWeatherInfoDataSource
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
        baseDate: Int,
        baseTime: Int,
        nx: String,
        ny: String
    ): Result<DomainWeatherInfoResponse> {
        val Remoteresponse = remoteGetWeatherInfoDataSource.getWeatherInfo(
            dataType, numOfRows, pageNo, baseDate, baseTime, nx, ny
        )
        return Result.success(
            DomainWeatherInfoResponse(
                Domainresponse = Remoteresponse.body()!!.response
            )
        )
    }
}