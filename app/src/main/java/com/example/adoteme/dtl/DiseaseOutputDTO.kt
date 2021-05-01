package com.example.adoteme.dtl

import com.example.adoteme.viewmodel.HealthViewModel
import com.google.gson.annotations.SerializedName

data class DiseaseOutputDTO(val healthViewModel: HealthViewModel) {

    @SerializedName("name")
    val name: String = healthViewModel.nameDisease
}
