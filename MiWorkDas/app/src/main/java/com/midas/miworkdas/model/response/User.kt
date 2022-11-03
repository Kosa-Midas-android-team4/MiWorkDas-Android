package com.midas.miworkdas.model.response

import java.io.Serializable

data class User(
    val memberCode: String,
    val memberDepart: String,
    val memberRank: String,
    val memberPhone: String,
    val memberIsAdmin: Int,
)