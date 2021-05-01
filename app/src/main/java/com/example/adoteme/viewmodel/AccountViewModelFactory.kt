package com.example.adoteme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adoteme.repository.AccountRepository

class AccountViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AccountViewModel::class.java)) {
            val repository = AccountRepository()
            return AccountViewModel(repository) as T
        }

        throw IllegalAccessException("Erro ao inicializar RegisterViewModel")
    }

}