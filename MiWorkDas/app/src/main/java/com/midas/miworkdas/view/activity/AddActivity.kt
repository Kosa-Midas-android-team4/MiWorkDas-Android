package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityAddBinding
import com.midas.miworkdas.viewmodel.AddViewModel

class AddActivity : BaseActivity<ActivityAddBinding, AddViewModel>() {
    override val mViewModel: AddViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_add

    override fun observeViewModel() {
        with(mViewModel){

        }
    }
}