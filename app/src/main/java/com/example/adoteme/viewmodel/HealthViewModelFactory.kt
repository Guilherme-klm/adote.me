package com.example.adoteme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HealthViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HealthViewModel::class.java))
            return HealthViewModel() as T

        throw IllegalAccessException("Erro ao inicializar RegisterViewModel")
    }
}