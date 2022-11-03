package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.viewmodel.UserDetailViewModel
import com.midas.miworkdas.databinding.ActivityUserDetailBinding

class UserDetailActivity : BaseActivity<ActivityUserDetailBinding, UserDetailViewModel>() {
    override val mViewModel: UserDetailViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_user_detail

    override fun observeViewModel() {
        with(mViewModel) {

        }
    }
}