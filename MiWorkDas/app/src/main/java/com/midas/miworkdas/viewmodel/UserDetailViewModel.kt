package com.midas.miworkdas.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.midas.miworkdas.Base.BaseViewModel
import com.midas.miworkdas.model.response.GetDetail
import com.midas.miworkdas.repository.MiRepository
import io.reactivex.rxjava3.observers.DisposableSingleObserver

class UserDetailViewModel : BaseViewModel() {
    private val repository = MiRepository()

    private val _getDetail = MutableLiveData<GetDetail>()
    val getDetail: LiveData<GetDetail> get() = _getDetail

    fun getUserDetail(memberCode: String){
        addDisposable(repository.getDetail(memberCode), object : DisposableSingleObserver<GetDetail>(){
            override fun onSuccess(t: GetDetail) {
                _getDetail.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                Log.e("error", "상세 정보 조회 중 오류 발생 : ${e.message}")
            }

        })

    }
}