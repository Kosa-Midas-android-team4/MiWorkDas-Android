package com.midas.miworkdas.viewmodel

import androidx.lifecycle.MutableLiveData
import com.midas.miworkdas.Base.BaseViewModel

class LoginViewModel : BaseViewModel() {
    val inputCode = MutableLiveData<String>()

    fun onClickLoginBtn(){

    }
}
