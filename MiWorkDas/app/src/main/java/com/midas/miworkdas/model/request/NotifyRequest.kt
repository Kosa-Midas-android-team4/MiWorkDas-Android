package com.midas.miworkdas.model.request

data class NotifyRequest(
    val memberName: String,
    val memberDepart: String,
    val memberRank: String,
    val memberPhone: String,
    val memberCode: String,
)