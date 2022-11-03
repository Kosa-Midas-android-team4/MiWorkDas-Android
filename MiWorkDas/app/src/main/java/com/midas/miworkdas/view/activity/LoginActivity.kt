package com.midas.miworkdas.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.midas.miworkdas.Base.BaseActivity
import com.midas.miworkdas.R
import com.midas.miworkdas.databinding.ActivityLoginBinding
import com.midas.miworkdas.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val mViewModel: LoginViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun observeViewModel() {
        with(mViewModel) {
            onErrorEvent.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity, "로그인 중 문제가 생겼습니다!", Toast.LENGTH_SHORT).show()
            })

            loginSuccess.observe(this@LoginActivity, Observer {
                if (it.success) {
                    when (it.code) {
                        0 -> {
                            Toast.makeText(
                                this@LoginActivity,
                                "입력한 코드는 존재하지 않습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        1 -> {
                            val intent = Intent(this@LoginActivity, AdminActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else -> {
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            intent.putExtra("code", mViewModel.inputCode.value)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    fun onClickLoginBtn() {
        if (mViewModel.inputCode.value?.length!! > 0) {
            mViewModel.actionLogin()
        } else {
            Toast.makeText(this, "회원 코드를 입력해주세요", Toast.LENGTH_SHORT).show()
        }
    }
}