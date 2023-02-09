package com.example.home.data

data class Weather(
    var probabilityPrecipitation: String = "",
    var windSpeed: String = "",
    var humidity: String = "",
    var sky: String = "",
    var temp: String = "",
    var fcstTime: String = "",
    var precipitationType: String = ""
)
