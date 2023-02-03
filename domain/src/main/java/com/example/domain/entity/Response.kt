package com.example.domain.entity

data class Response(
    val header: Header,
    val body: Body
){
    data class Header(
        val resultCode: Int,
        val resultMsg: String
    )

    data class Body(
        val dataType: String,
        val items: Items,
        val totalCount : Int
    )

    data class Items(
        val item: List<Item>
    )

    data class Item(
        val baseData: Int,
        val category: String,
        val fcstDate: Int,
        val fcstValue: String,
        val baseTime: Int,
        val nx: Int,
        val ny: Int
    )
}


