package com.midas.miworkdas.model.request

data class UserRequest(
    val memberName: String,
    val memberDepart: String,
    val memberRank: String,
    val memberPhone: String,
    val memberIsAdmin: Boolean
)