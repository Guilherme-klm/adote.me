package com.example.adoteme.model

class UserLogged {

    var id = 0

    var name = ""

    companion object {
        var user = UserLogged()

        fun getInstance(): UserLogged {
            if (user == null)
                user = UserLogged()
            return user
        }
    }
}