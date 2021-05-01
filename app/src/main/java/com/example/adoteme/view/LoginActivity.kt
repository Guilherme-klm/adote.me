package com.example.adoteme.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.adoteme.R
import com.example.adoteme.databinding.ActivityLoginBinding
import com.example.adoteme.viewmodel.LoginViewModel
import com.example.adoteme.viewmodel.LoginViewModelFactory
import com.google.android.material.progressindicator.CircularProgressIndicator
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        redirectToMainActivity()

        var binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.loginActivityViewModel = loginViewModel
    }

    fun login(view: View) {
        loginViewModel.save()
    }

    fun redirectToCreateAccountActivity(view: View) {
        val intent = Intent(this, CreateAccountActivity::class.java)
        startActivity(intent)
    }

    private fun redirectToMainActivity() {
        loginViewModel.redirect.observe(this, {
            if(it) {
                val intent = Intent(this, HomePageActivity::class.java)
                startActivity(intent)
            }
        })
    }
}