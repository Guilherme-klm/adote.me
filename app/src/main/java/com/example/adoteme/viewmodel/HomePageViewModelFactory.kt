package com.example.adoteme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adoteme.repository.LoginRepository
import com.example.adoteme.repository.PublicationRepository

class HomePageViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomePageViewModel::class.java)) {
            val repository = PublicationRepository()
            return HomePageViewModel(repository) as T
        }
        throw IllegalAccessException("Erro ao inicializar RegisterViewModel")
    }
}