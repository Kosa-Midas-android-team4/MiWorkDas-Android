package com.midas.miworkdas.viewmodel

import android.os.Build.VERSION_CODES.M
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.midas.miworkdas.Base.BaseViewModel

class LoginViewModel : BaseViewModel() {
    val inputCode = MutableLiveData<String>()

    fun onClickLoginBtn(){
        //로그인 처리
    }
}
