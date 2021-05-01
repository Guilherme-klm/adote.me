package com.example.adoteme.dtl

import com.example.adoteme.viewmodel.HealthViewModel
import com.example.adoteme.viewmodel.RegisterViewModel
import com.google.gson.annotations.SerializedName
import com.nguyenhoanglam.imagepicker.model.Image

data class AnimalOutputDTO(val registerViewModel: RegisterViewModel, val healthViewModel: HealthViewModel) {

    @SerializedName("name")
    val name: String = registerViewModel.nameAnimal

    @SerializedName("breed")
    val breed: String = registerViewModel.breed

    @SerializedName("vaccine")
    val vaccineOutputDTO: VaccineOutputDTO = VaccineOutputDTO(healthViewModel)

    @SerializedName("remedy")
    val remedyOutputDTO: RemedyOutputDTO = RemedyOutputDTO(healthViewModel)

    @SerializedName("disease")
    val disease: DiseaseOutputDTO = DiseaseOutputDTO(healthViewModel)

}