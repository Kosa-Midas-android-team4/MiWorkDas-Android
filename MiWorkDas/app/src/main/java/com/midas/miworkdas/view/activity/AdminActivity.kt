package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityAdminBinding
import com.midas.miworkdas.viewmodel.AdminViewModel

class AdminActivity : BaseActivity<ActivityAdminBinding, AdminViewModel>() {
    override val mViewModel: AdminViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_admin

    override fun observeViewModel() {
        with(mViewModel) {

        }
    }
}