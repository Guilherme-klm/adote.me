package com.example.adoteme.model

import com.google.gson.annotations.SerializedName

class Login {

    @SerializedName("email")
    var email = ""

    @SerializedName("password")
    var password = ""
}