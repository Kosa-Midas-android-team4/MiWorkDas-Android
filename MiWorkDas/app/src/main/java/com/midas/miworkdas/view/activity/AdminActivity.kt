package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityAdminBinding
import com.midas.miworkdas.view.adapter.UserAdapter
import com.midas.miworkdas.viewmodel.AdminViewModel

class AdminActivity : BaseActivity<ActivityAdminBinding, AdminViewModel>() {
    override val mViewModel: AdminViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_admin

    lateinit var adpater: UserAdapter

    override fun observeViewModel() {
        adpater = UserAdapter(this)
        with(mViewModel) {
            onErrorEvent.observe(this@AdminActivity, Observer {
                Toast.makeText(this@AdminActivity, "조회 중 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })

            users.observe(this@AdminActivity, Observer {
                if (it.success) {
                    if (it.success) {
                        mBinding.recyclerView.adapter = adpater
                        adpater.submitList(it.userList)
                    } else {
                        Toast.makeText(this@AdminActivity, "문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}