package com.midas.miworkdas.repository

import com.midas.miworkdas.model.Server
import com.midas.miworkdas.model.request.MemberRequest
import com.midas.miworkdas.model.response.*
import io.reactivex.rxjava3.core.Single
import org.json.JSONObject

class MiRepository {
    fun login(memberCode: String): Single<Login> {
        return Server.miApi.login(MemberRequest(memberCode)).map {
            if (!it.isSuccessful) {
                val error = JSONObject(it.errorBody()!!.toString())
                throw Throwable(error.getString("message"))
            }

            it.body()!!
        }
    }

    fun workStart(memberCode: String): Single<WorkStart> {
        return Server.miApi.workStart(MemberRequest(memberCode)).map {
            if (!it.isSuccessful) {
                val error = JSONObject(it.errorBody()!!.toString())
                throw Throwable(error.getString("message"))
            }

            it.body()!!
        }
    }

    fun workEnd(memberCode: String): Single<WorkEnd> {
        return Server.miApi.workEnd(MemberRequest(memberCode)).map {
            if (!it.isSuccessful) {
                val error = JSONObject(it.errorBody()!!.toString())
                throw Throwable(error.getString("message"))
            }
            it.body()!!
        }
    }

    fun getAll(): Single<User>{
        return Server.miApi.getAll().map {
            if (!it.isSuccessful) {
                val error = JSONObject(it.errorBody()!!.toString())
                throw Throwable(error.getString("message"))
            }
            it.body()!!
        }
    }

    fun getDetail(memberCode: String): Single<Detail>{
        return Server.miApi.getDetail(MemberRequest(memberCode)).map {
            if (!it.isSuccessful) {
                val error = JSONObject(it.errorBody()!!.toString())
                throw Throwable(error.getString("message"))
            }

            it.body()!!
        }
    }
}