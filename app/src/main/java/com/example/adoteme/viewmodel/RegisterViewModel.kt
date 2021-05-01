package com.example.adoteme.viewmodel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import androidx.databinding.Bindable
import okhttp3.MultipartBody
import java.io.ByteArrayOutputStream


class RegisterViewModel : BaseViewModel() {

    @Bindable
    var nameAnimal: String = "";

    @Bindable
    var image: String? = null

    @Bindable
    var breed: String = "";

    @Bindable
    var state: String = "";

    @Bindable
    var city: String = "";

    @Bindable
    var neighborhood: String = "";

    @Bindable
    var street: String = "";

}