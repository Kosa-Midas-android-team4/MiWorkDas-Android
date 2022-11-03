package com.midas.miworkdas.repository

import com.midas.miworkdas.model.Server
import com.midas.miworkdas.model.request.LoginRequest
import com.midas.miworkdas.model.response.LoginResponse
import io.reactivex.rxjava3.core.Single
import org.json.JSONObject

class MiRepository {
    fun login(memberCode: String): Single<LoginResponse> {
        return Server.miApi.login(LoginRequest(memberCode)).map {
            if(!it.isSuccessful){
                val error = JSONObject(it.errorBody()!!.toString())
                throw Throwable(error.getString("message"))
            }

            it.body()!!
        }
    }
}