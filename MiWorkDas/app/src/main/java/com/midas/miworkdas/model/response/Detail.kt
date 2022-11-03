package com.midas.miworkdas.model.response

data class Detail(
    val isWorking: Int,
    val memberName: String,
    val memberDepart: String,
    val memberRank: String,
    val memberPhone: String,
    val memberIsAdmin: Int,
    val memberWeekHour: Int,
    val memberWorkDate: Int,
)
