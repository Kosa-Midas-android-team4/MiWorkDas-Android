package com.midas.miworkdas.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.midas.miworkdas.Base.BaseViewModel
import com.midas.miworkdas.model.request.UserRequest
import com.midas.miworkdas.model.response.Register
import com.midas.miworkdas.repository.MiRepository
import io.reactivex.rxjava3.observers.DisposableSingleObserver

class AddViewModel : BaseViewModel() {
    private val repository = MiRepository()

    val inputName = MutableLiveData<String>()
    val inputDepart = MutableLiveData<String>()
    val inputRank = MutableLiveData<String>()
    val inputPhone = MutableLiveData<String>()

    private val _successRegister = MutableLiveData<Register>()
    val successRegister: LiveData<Register> get() = _successRegister

    fun register() {
        addDisposable(
            repository.register(
                UserRequest(
                    inputName.value!!,
                    inputDepart.value!!,
                    inputRank.value!!,
                    inputPhone.value!!,
                    false
                )
            ), object: DisposableSingleObserver<Register>(){
                override fun onSuccess(t: Register) {
                    _successRegister.value = t
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                    Log.e("error","회원 추가 중 오류 발생 : ${e.message}")
                }

            }
        )
    }
}