package com.midas.miworkdas.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.midas.miworkdas.Base.BaseViewModel
import com.midas.miworkdas.model.response.GetAll
import com.midas.miworkdas.model.response.User
import com.midas.miworkdas.repository.MiRepository
import io.reactivex.rxjava3.observers.DisposableSingleObserver

class AdminViewModel : BaseViewModel() {
    private val repository = MiRepository()

    private val _users = MutableLiveData<GetAll>()
    val users: LiveData<GetAll> get() = _users

    init {
        getAllUsers()
    }

    fun getAllUsers() {
        addDisposable(repository.getAll(), object : DisposableSingleObserver<GetAll>() {
            override fun onSuccess(t: GetAll) {
                _users.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                Log.e("error", "유저 전체 조회 중 오류 발생 : ${e.message}")
            }

        })
    }
}