package com.midas.miworkdas.model.response

import java.io.Serializable

data class GetDetail(
    val success: Boolean,
    val user: Detail,
):Serializable