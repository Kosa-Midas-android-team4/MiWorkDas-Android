package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityModifyBinding
import com.midas.miworkdas.viewmodel.ModifyViewModel

class ModifyActivity : BaseActivity<ActivityModifyBinding, ModifyViewModel>() {
    override val mViewModel: ModifyViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_modify

    override fun observeViewModel() {
        with(mViewModel){

        }
    }
}