package com.midas.miworkdas.model.response

data class User(
    val isWorking: Int,
    val memberCode:String,
    val memberDepart: String,
    val memberIsAdmin: Int,
    val memberName: String,
    val memberPhone: String,
    val memberRank: String,
)
