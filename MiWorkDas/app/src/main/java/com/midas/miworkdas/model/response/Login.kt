package com.midas.miworkdas.model.response

data class Login(
    val success: Boolean,
    val code: Int,
    val user: User?,
)
