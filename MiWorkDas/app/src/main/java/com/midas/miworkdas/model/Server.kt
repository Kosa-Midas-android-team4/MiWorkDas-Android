package com.midas.miworkdas.model

import com.midas.miworkdas.model.api.MiApi
import com.midas.miworkdas.util.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Server {
    private val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val server =
        Retrofit.Builder().baseUrl(Constant.HOST).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).client(client).build()

    val miApi: MiApi = server.create(MiApi::class.java)
}