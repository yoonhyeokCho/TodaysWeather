package com.example.domain.entity.response

data class DomainWeatherInfoResponse(
    var rainType: String = "",
    var humidity: String = "",
    var sky: String = "",
    var temp: String = "",
    var fcstTime: String = ""
){
    data class WEATHER(val response: RESPONSE)
    data class RESPONSE(val header: HEADER, val body: BODY)
    data class HEADER(val resultCode: Int, val resultMsg: String)
    data class BODY(val dataType: String, val items: ITEMS, val totalCount: Int)
    data class ITEMS(val item: List<ITEM>)
    data class ITEM(
        val category: String,
        val fcstDate: String,
        val fcstTime: String,
        val fcstValue: String
    )
}
