package com.example.domain.repository

import com.example.domain.entity.response.DomainWeatherInfoResponse

interface HomeRepository {
    suspend fun getWeatherInfo(
        dataType: String,
        numOfRows: Int,
        pageNo: Int,
        baseDate: String,
        baseTime: String,
        nx: Int,
        ny: Int
    ): Result<DomainWeatherInfoResponse>
}