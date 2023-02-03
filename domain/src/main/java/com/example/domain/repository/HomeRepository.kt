package com.example.domain.repository

import com.example.domain.entity.response.DomainWeatherInfoResponse

interface HomeRepository {
    suspend fun getWeatherInfo(
        dataType: String,
        numOfRows: Int,
        pageNo: Int,
        baseDate: Int,
        baseTime: Int,
        nx: String,
        ny: String
    ): Result<DomainWeatherInfoResponse>
}