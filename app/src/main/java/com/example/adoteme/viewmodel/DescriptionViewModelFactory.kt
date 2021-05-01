package com.example.adoteme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DescriptionViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DescriptionViewModel::class.java))
            return DescriptionViewModel() as T

        throw IllegalAccessException("Erro ao inicializar RegisterViewModel")
    }

}