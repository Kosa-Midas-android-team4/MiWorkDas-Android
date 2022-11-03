package com.midas.miworkdas.model.response

data class GetAll(
    val success: Boolean,
    val userList: List<User>
)
