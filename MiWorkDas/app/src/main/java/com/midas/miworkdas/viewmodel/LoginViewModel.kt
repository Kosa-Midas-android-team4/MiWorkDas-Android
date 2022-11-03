package com.midas.miworkdas.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.midas.miworkdas.Base.BaseViewModel
import com.midas.miworkdas.model.response.LoginResponse
import com.midas.miworkdas.repository.MiRepository
import io.reactivex.rxjava3.observers.DisposableSingleObserver

class LoginViewModel : BaseViewModel() {
    private val repository = MiRepository()
    val inputCode = MutableLiveData<String>()

    private val _loginSuccess = MutableLiveData<LoginResponse>()
    val loginSuccess: LiveData<LoginResponse> get() = _loginSuccess

    fun actionLogin(){
        addDisposable(repository.login(inputCode.value!!), object: DisposableSingleObserver<LoginResponse>(){
            override fun onSuccess(t: LoginResponse) {
                _loginSuccess.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                Log.e("network error","로그인 에러 : $e")
            }

        })
    }
}
