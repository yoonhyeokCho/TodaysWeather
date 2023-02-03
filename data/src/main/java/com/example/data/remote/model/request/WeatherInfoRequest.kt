package com.example.data.remote.model.request

import com.google.gson.annotations.SerializedName
import retrofit2.http.Query

data class WeatherInfoRequest(
    @Query("dataType")
    var dataType: String,
    @Query("numOfRows")
    var numOfRows: Int,
    @Query("pageNo")
    var pageNo: Int,
    @Query("base_date")
    var baseDate: Int,
    @Query("base_time")
    var baseTime: Int,
    @Query("nx")
    var nx: String,
    @Query("ny")
    var ny: String
)
