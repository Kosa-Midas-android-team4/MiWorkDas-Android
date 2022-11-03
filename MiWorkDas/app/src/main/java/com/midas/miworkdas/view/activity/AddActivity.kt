package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityAddBinding
import com.midas.miworkdas.viewmodel.AddViewModel

class AddActivity : BaseActivity<ActivityAddBinding, AddViewModel>() {
    override val mViewModel: AddViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_add

    override fun observeViewModel() {
        with(mViewModel) {
            onErrorEvent.observe(this@AddActivity, Observer {
                Toast.makeText(this@AddActivity, "회원 추가 중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })

            successRegister.observe(this@AddActivity, Observer {
                if (it.success) {
                    if (it.already) {
                        Toast.makeText(this@AddActivity, "이미 존재하는 회원입니다", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            this@AddActivity,
                            "회원 추가 성공했습니다. ${it.memberCode}",
                            Toast.LENGTH_LONG
                        ).show()
                        finish()
                    }
                } else {
                    Toast.makeText(this@AddActivity, "회원 추가 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    fun onClickAddBtn() {
        if (mViewModel.inputName.value != "" && mViewModel.inputDepart.value != "" && mViewModel.inputRank.value != "" && mViewModel.inputPhone.value != "") {
            mViewModel.register()
        } else {
            Toast.makeText(this, "모두 입력해주세요!", Toast.LENGTH_SHORT).show()
        }
    }
}