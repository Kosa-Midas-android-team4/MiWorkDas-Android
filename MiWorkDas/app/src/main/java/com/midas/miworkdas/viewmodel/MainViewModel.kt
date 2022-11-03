package com.midas.miworkdas.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.midas.miworkdas.Base.BaseViewModel
import com.midas.miworkdas.model.response.*
import com.midas.miworkdas.repository.MiRepository
import io.reactivex.rxjava3.observers.DisposableSingleObserver

class MainViewModel : BaseViewModel() {
    private val repository = MiRepository()

    private val _getDetail = MutableLiveData<Detail>()
    val getDetail: LiveData<Detail> get() = _getDetail

    private val _workStart = MutableLiveData<WorkStart>()
    val workStart: LiveData<WorkStart> get() = _workStart

    private val _workEnd = MutableLiveData<WorkEnd>()
    val workEnd: LiveData<WorkEnd> get() = _workEnd



    fun getDetail(memberCode: String){
        addDisposable(repository.getDetail(memberCode), object : DisposableSingleObserver<GetDetail>(){
            override fun onSuccess(t: GetDetail) {
                _getDetail.value = t.detail
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                Log.e("error", "상세 정보 조회 중 오류 발생 : ${e.message}")
            }

        })
    }

    fun workStart(memberCode: String){
        addDisposable(repository.workStart(memberCode), object : DisposableSingleObserver<WorkStart>(){
            override fun onSuccess(t: WorkStart) {
                _workStart.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                Log.e("error", "출근 중 오류 발생 : ${e.message}")
            }

        })
    }

    fun workEnd(memberCode: String){
        addDisposable(repository.workEnd(memberCode), object : DisposableSingleObserver<WorkEnd>(){
            override fun onSuccess(t: WorkEnd) {
                _workEnd.value = t
            }

            override fun onError(e: Throwable) {
                onErrorEvent.value = e
                Log.e("error", "퇴근 중 오류 발생 : ${e.message}")
            }

        })
    }
}