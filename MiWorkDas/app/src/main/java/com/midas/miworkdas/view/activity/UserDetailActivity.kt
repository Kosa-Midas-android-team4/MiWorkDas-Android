package com.midas.miworkdas.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.viewmodel.UserDetailViewModel
import com.midas.miworkdas.databinding.ActivityUserDetailBinding
import com.midas.miworkdas.model.response.GetDetail

class UserDetailActivity : BaseActivity<ActivityUserDetailBinding, UserDetailViewModel>() {
    override val mViewModel: UserDetailViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_user_detail

    private var memberCode: String = ""
    private lateinit var item: GetDetail

    override fun onResume() {
        super.onResume()
        if (memberCode != "") {
            mViewModel.getUserDetail(memberCode)
        }
    }

    override fun observeViewModel() {
        getMemberCode()
        with(mViewModel) {
            onErrorEvent.observe(this@UserDetailActivity, Observer {
                Toast.makeText(
                    this@UserDetailActivity,
                    "유저 상세 정보 조회 중 문제가 발생했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            })

            getDetail.observe(this@UserDetailActivity, Observer {
                mBinding.detailTvDepart.text = it.user.memberDepart
                mBinding.detailTvName.text = "${it.user.memberName} ${it.user.memberRank}님"
                mBinding.detailTvPhone.text = it.user.memberPhone


                val hour: Int = (it.user.memberWorkDate.toInt() / 60) / 60
                val min: Int = (it.user.memberWorkDate.toInt() / 60) % 60
                mBinding.detailTvToday.text= "오늘 총 : ${hour}시간 ${min}분"

                mBinding.progressBar.progress = it.user.memberWeekHour / 60
                val leftHour: Int = (it.user.memberWeekHour / 60) / 60
                mBinding.detailTvWeek.text = "${leftHour}시간"
            })
        }
    }

    fun onClickModifyBtn() {
        val intent = Intent(this, ModifyActivity::class.java)
        intent.putExtra("key", memberCode)
        startActivity(intent)
    }

    private fun getMemberCode() {
        memberCode = intent.getStringExtra("memberCode").toString()
        mViewModel.getUserDetail(memberCode)
    }
}