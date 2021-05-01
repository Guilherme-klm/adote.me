package com.example.adoteme.dtl

import com.example.adoteme.viewmodel.HealthViewModel
import com.google.gson.annotations.SerializedName

data class VaccineOutputDTO(val healthViewModel: HealthViewModel) {

    @SerializedName("name")
    val name: String = healthViewModel.nameVaccine

    @SerializedName("date")
    val date: String = healthViewModel.dateVaccine

    @SerializedName("validity")
    val validity: String = healthViewModel.validityVaccine

}
