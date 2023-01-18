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
    var baseDate: String,
    @Query("base_time")
    var baseTime: String,
    @Query("nx")
    var nx: Int,
    @Query("ny")
    var ny: Int
)
