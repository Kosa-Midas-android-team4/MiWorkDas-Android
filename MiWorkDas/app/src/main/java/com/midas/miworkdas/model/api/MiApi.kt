package com.midas.miworkdas.model.api

import com.midas.miworkdas.model.request.LoginRequest
import com.midas.miworkdas.model.response.Login
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST


interface MiApi {
    @POST("login/")
    fun login(@Body request: LoginRequest): Single<retrofit2.Response<Login>>


}