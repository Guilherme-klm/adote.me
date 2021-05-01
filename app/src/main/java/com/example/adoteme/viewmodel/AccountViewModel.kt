package com.example.adoteme.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.adoteme.BR
import com.example.adoteme.model.Account
import com.example.adoteme.model.Address
import com.example.adoteme.model.ErrorMessage
import com.example.adoteme.repository.AccountRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch
import org.json.JSONObject

class AccountViewModel(private val repository: AccountRepository) : BaseViewModel() {

    @Bindable
    var name = "AFAKLJFKLAS"

    @Bindable
    var date = "10/12/2000"

    @Bindable
    var email = "AFWAFAF"

    @Bindable
    var password = "AFAWFAWFWAFF"

    @Bindable
    var country = "AFAWFAF"

    @Bindable
    var state = "AWFWAFAFWAFF"

    @Bindable
    var city = "AFAWFAWFWAF"

    @Bindable
    var neighborhood = "FAFWAFAWF"

    @Bindable
    var street = "ERDFGDGDFG"

    @Bindable
    var number = ""

    @Bindable
    var errorMessage = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.errorMessage)
        }

    var redirect: MutableLiveData<Boolean> = MutableLiveData(false)

    fun save() {
        var account = Account(name, date, email, password, Address(country, state, city, neighborhood, street, number.toInt()))

        viewModelScope.launch {
            var response = repository.createAccount(account);

            if(response.isSuccessful) {
                redirect.postValue(true)
            } else {
                errorMessage = Gson().fromJson(response.errorBody()!!.charStream(), ErrorMessage::class.java).message
            }
        }
    }
}