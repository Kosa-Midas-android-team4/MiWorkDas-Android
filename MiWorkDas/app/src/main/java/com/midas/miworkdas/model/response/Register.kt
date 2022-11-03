package com.midas.miworkdas.model.response

data class Register(
    val success: Boolean,
    val already: Boolean,
    val memberCode: String,
)