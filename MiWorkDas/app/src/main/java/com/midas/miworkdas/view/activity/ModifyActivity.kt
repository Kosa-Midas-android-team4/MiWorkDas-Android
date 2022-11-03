package com.midas.miworkdas.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityModifyBinding
import com.midas.miworkdas.model.response.Detail
import com.midas.miworkdas.model.response.User
import com.midas.miworkdas.viewmodel.ModifyViewModel

class ModifyActivity : BaseActivity<ActivityModifyBinding, ModifyViewModel>() {
    override val mViewModel: ModifyViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_modify

    override fun observeViewModel() {
        with(mViewModel) {
            onErrorEvent.observe(this@ModifyActivity, Observer {
                Toast.makeText(this@ModifyActivity, "회원 정보 수정 중 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })

            successModify.observe(this@ModifyActivity, Observer {
                if(it.success){
                    Toast.makeText(this@ModifyActivity, "회원 정보 수정 성공!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@ModifyActivity, "회원 정보 수정에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    fun onClickModifyBtn(){
        if (mViewModel.inputName.value != "" && mViewModel.inputDepart.value != "" && mViewModel.inputRank.value != "" && mViewModel.inputPhone.value != "") {
            mViewModel.modify()
        } else {
            Toast.makeText(this, "모두 입력해주세요!", Toast.LENGTH_SHORT).show()
        }
    }
}