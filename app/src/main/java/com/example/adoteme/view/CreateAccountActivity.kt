package com.example.adoteme.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.adoteme.R
import com.example.adoteme.databinding.ActivityCreateAcccountBinding
import com.example.adoteme.viewmodel.AccountViewModel
import com.example.adoteme.viewmodel.AccountViewModelFactory
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class CreateAccountActivity : AppCompatActivity() {

    private val accountViewModel: AccountViewModel by viewModels {
        AccountViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acccount)

        var binding: ActivityCreateAcccountBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_acccount)
        binding.accountViewModel = accountViewModel

        redirectLoginActivity()
    }

    fun create(view: View) {
        accountViewModel.save()
    }

    fun redirectLoginActivity() {
        accountViewModel.redirect.observe(this, {
            if (it) {
                Toast.makeText(applicationContext, "Conta Criada com sucesso!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}