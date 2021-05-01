package com.example.adoteme.dtl

import com.example.adoteme.model.PublicationUser
import com.example.adoteme.viewmodel.DescriptionViewModel
import com.example.adoteme.viewmodel.HealthViewModel
import com.example.adoteme.viewmodel.RegisterViewModel
import com.google.gson.annotations.SerializedName
data class PublicationOutputDTO(val registerViewModel: RegisterViewModel, val healthViewModel: HealthViewModel, val descriptionViewModel: DescriptionViewModel) {

    @SerializedName("description")
    val description: String = descriptionViewModel.description

    @SerializedName("state")
    val state: String = registerViewModel.state

    @SerializedName("city")
    val city: String = registerViewModel.city

    @SerializedName("neighborhood")
    val neighborhood: String = registerViewModel.neighborhood

    @SerializedName("street")
    val street: String = registerViewModel.street

    @SerializedName("user")
    val publicationUser = PublicationUser()

    @SerializedName("animal")
    val animal = AnimalOutputDTO(registerViewModel, healthViewModel)

}