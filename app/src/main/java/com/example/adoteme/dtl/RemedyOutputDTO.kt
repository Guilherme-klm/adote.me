package com.example.adoteme.dtl

import com.example.adoteme.viewmodel.HealthViewModel
import com.google.gson.annotations.SerializedName

data class RemedyOutputDTO(val healthViewModel: HealthViewModel) {

    @SerializedName("name")
    val name: String = healthViewModel.nameRemedy

    @SerializedName("date")
    val date: String = healthViewModel.dateRemedy

    @SerializedName("validity")
    val validity: String = healthViewModel.validityRemedy

}
