package com.example.adoteme.viewmodel

import androidx.databinding.Bindable

class HealthViewModel : BaseViewModel() {

    @Bindable
    var nameVaccine: String = "";

    @Bindable
    var dateVaccine: String = "";

    @Bindable
    var validityVaccine: String = "";

    @Bindable
    var nameRemedy: String = "";

    @Bindable
    var dateRemedy: String = "";

    @Bindable
    var validityRemedy: String = "";

    @Bindable
    var nameDisease: String = "";
}