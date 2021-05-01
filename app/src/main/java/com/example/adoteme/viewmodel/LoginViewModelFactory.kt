package com.example.adoteme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adoteme.repository.LoginRepository

class LoginViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            var repository = LoginRepository()
            return LoginViewModel(repository) as T
        }
        throw IllegalAccessException("Erro ao inicializar RegisterViewModel")
    }
}