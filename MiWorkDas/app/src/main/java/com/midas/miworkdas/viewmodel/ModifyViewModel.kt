package com.midas.miworkdas.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.midas.miworkdas.Base.BaseViewModel
import com.midas.miworkdas.model.request.UserRequest
import com.midas.miworkdas.model.response.OnlyBoolean
import com.midas.miworkdas.repository.MiRepository
import io.reactivex.rxjava3.observers.DisposableSingleObserver

class ModifyViewModel : BaseViewModel() {
    private val repository = MiRepository()

    val inputName = MutableLiveData<String>()
    val inputDepart = MutableLiveData<String>()
    val inputRank = MutableLiveData<String>()
    val inputPhone = MutableLiveData<String>()

    private val _successModify = MutableLiveData<OnlyBoolean>()
    val successModify: LiveData<OnlyBoolean> get() = _successModify

    fun modify(){
        addDisposable(repository.userUpdate(UserRequest(inputName.value!!,
            inputDepart.value!!,
            inputRank.value!!,
            inputPhone.value!!,
            false)), object : DisposableSingleObserver<OnlyBoolean>(){
            override fun onSuccess(t: OnlyBoolean) {
                _successModify.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                Log.e("Error", "수정 중 오류 발생 : ${e}")
            }

        })
    }
}