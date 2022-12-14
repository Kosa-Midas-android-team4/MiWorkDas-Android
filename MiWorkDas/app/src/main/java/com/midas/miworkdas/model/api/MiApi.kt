package com.midas.miworkdas.model.api

import com.midas.miworkdas.model.request.MemberRequest
import com.midas.miworkdas.model.request.NotifyRequest
import com.midas.miworkdas.model.request.UserRequest
import com.midas.miworkdas.model.response.*
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST


interface MiApi {
    @POST("login/")
    fun login(@Body request: MemberRequest): Single<retrofit2.Response<Login>>

    @POST("saveStartWork/")
    fun workStart(@Body request: MemberRequest): Single<retrofit2.Response<OnlyBoolean>>

    @POST("saveEndWork/")
    fun workEnd(@Body request:MemberRequest): Single<retrofit2.Response<WorkEnd>>

    @POST("inquireUser/")
    fun getAll(): Single<retrofit2.Response<GetAll>>

    @POST("getUserAllInfo/")
    fun getDetail(@Body request: MemberRequest): Single<retrofit2.Response<GetDetail>>

    @POST("registeUser/")
    fun register(@Body request: UserRequest): Single<retrofit2.Response<Register>>

    @POST("updateUser")
    fun updateUser(@Body request: NotifyRequest): Single<retrofit2.Response<OnlyBoolean>>
}