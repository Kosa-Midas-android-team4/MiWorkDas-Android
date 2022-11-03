package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityMainBinding
import com.midas.miworkdas.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun observeViewModel() {
        with(mViewModel) {

        }
    }
}