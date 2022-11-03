package com.midas.miworkdas.model.response

import java.io.Serializable

data class Detail(
    val memberCode: String,
    val isWorking: Int,
    val memberName: String,
    val memberDepart: String,
    val memberRank: String,
    val memberPhone: String,
    val memberIsAdmin: Int,
    val memberWeekHour: Int,
    val memberWorkDate: Int,
): Serializable
