package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityMainBinding
import com.midas.miworkdas.model.response.User
import com.midas.miworkdas.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_main

    private var memberCode: String = ""
    private lateinit var user: User

    override fun observeViewModel() {
        getMemberCode()
        with(mViewModel) {
            onErrorEvent.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, "오류가 발생했습니다.", Toast.LENGTH_SHORT)
                    .show()
            })

            getDetail.observe(this@MainActivity, Observer {
                mBinding.mainTvDepart.text = it.memberDepart
                mBinding.mainTvName.text = "${it.memberName} ${it.memberRank}님"

                if (it.isWorking > 0) {
                    mBinding.mainBtn.text = "퇴근하기"
                    mBinding.mainBtn.setOnClickListener {
                        mViewModel.workEnd(memberCode)
                    }
                } else {
                    mBinding.mainBtn.text = "출근하기"
                    mBinding.mainBtn.setOnClickListener {
                        mViewModel.workStart(memberCode)
                    }
                }

                if (it.isWorking == 0 && it.memberWorkDate > 0) {
                    val hour: Int = (it.memberWorkDate / 60) / 60
                    val min: Int = (it.memberWorkDate / 60) / 60
                    mBinding.mainTvTodayhint.text = "오늘 ${hour}시간 ${min}분 일했어요"
                    mBinding.mainTvTodayhint.isVisible = true
                }

                mBinding.mainProgressTime.progress = it.memberWeekHour / 60

                val leftHour: Int = (it.memberWeekHour / 60) / 60
                val leftMin: Int = (it.memberWeekHour / 60) / 60
                mBinding.mainTvLeft.text = "오늘 ${leftHour}시간 ${leftMin}분 일했어요"
            })

            workStart.observe(this@MainActivity, Observer {
                if(it.success){
                    Toast.makeText(this@MainActivity, "오늘 하루도 화이팅!", Toast.LENGTH_SHORT).show()

                    mBinding.mainBtn.text = "퇴근하기"
                    mBinding.mainBtn.setOnClickListener {
                        mViewModel.workEnd(memberCode)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "출근 요청에 실패 했어요...", Toast.LENGTH_SHORT).show()
                }
            })

            workEnd.observe(this@MainActivity, Observer {
                if(it.success){
                    val hour: Int = (it.memberWorkTime.toInt() / 60) / 60
                    val min: Int = (it.memberWorkTime.toInt() / 60) / 60
                    mBinding.mainTvTodayhint.text = "오늘 ${hour}시간 ${min}분 일했어요"
                    mBinding.mainTvTodayhint.isVisible = true

                    mBinding.mainProgressTime.progress = it.memberWeekHour / 60
                    val leftHour: Int = (it.memberWeekHour / 60) / 60
                    val leftMin: Int = (it.memberWeekHour / 60) / 60
                    mBinding.mainTvLeft.text = "오늘 ${leftHour}시간 ${leftMin}분 일했어요"

                    mBinding.mainBtn.text = "출근하기"
                    mBinding.mainBtn.setOnClickListener {
                        mViewModel.workStart(memberCode)
                    }

                } else {
                    Toast.makeText(this@MainActivity, "퇴근 요청에 실패 했어요...", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun getMemberCode() {
        memberCode = intent?.getStringExtra("code").toString()
        mViewModel.getDetail(memberCode)
    }
}