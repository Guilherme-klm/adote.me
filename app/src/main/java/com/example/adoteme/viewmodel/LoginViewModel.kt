package com.example.adoteme.viewmodel

import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.adoteme.BR
import com.example.adoteme.model.Login
import com.example.adoteme.repository.LoginRepository
import com.example.adoteme.model.UserLogged
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class LoginViewModel(private val loginRepository: LoginRepository) : BaseViewModel() {

    @Bindable
    var email = "guilherme-klm@hotmail.com"

    @Bindable
    var password = "123"

    @Bindable
    var loadingVisibility = View.GONE
        set(value) {
            field = value
            notifyPropertyChanged(BR.loadingVisibility)
        }

    @Bindable
    var errorMessage = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.errorMessage)
        }

    var redirect: MutableLiveData<Boolean> = MutableLiveData(false)

    fun save() {
        this.loadingVisibility = View.VISIBLE

        viewModelScope.launch(Dispatchers.IO) {
            var loginConverted = Login()
            loginConverted.email = email
            loginConverted.password = password

            val hasAccount = loginRepository.save(loginConverted)
            var userLogged = UserLogged.getInstance()

            if (hasAccount.body() != null) {
                userLogged.id = hasAccount.body()!!.id
                userLogged.name = hasAccount.body()!!.name
            }

            if (hasAccount != null) {
                if (hasAccount.isSuccessful) {
                    delay(1000)
                    redirect.postValue(true)
                }
                else showError("Email ou senha incorretos!")
            }
            loadingVisibility = View.GONE
        }
    }

    private fun showError(message: String?) {
        this.errorMessage = message ?: "Erro Desconhecido"
    }
}