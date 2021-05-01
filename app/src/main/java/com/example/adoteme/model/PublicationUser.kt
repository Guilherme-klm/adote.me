package com.example.adoteme.model

import com.google.gson.annotations.SerializedName

class PublicationUser {

    @SerializedName("id")
    val id: Long = UserLogged.getInstance().id.toLong()

    @SerializedName("name")
    val name: String = UserLogged.getInstance().name
}



