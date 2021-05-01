package com.example.adoteme.service

import com.example.adoteme.model.Login
import com.google.gson.Gson
import org.json.JSONObject

class LoginConverter(private val email: String, private val password: String) {

    fun createJsonLogin(): Login {
        val loginObject = JSONObject()
        loginObject.put("email", email)
        loginObject.put("password", password)

        return convertJsonToGson(loginObject)
    }

    private fun convertJsonToGson(loginJsonObject: JSONObject): Login {
        return Gson().fromJson(loginJsonObject.toString(), Login::class.java)
    }
}
