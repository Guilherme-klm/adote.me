package com.example.adoteme.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.adoteme.R
import com.example.adoteme.databinding.ActivityCreatePublicationBinding
import com.example.adoteme.dtl.PublicationOutputDTO
import com.example.adoteme.model.ErrorMessage
import com.example.adoteme.repository.PublicationRepository
import com.example.adoteme.viewmodel.*
import com.google.gson.Gson
import com.nguyenhoanglam.imagepicker.model.Config.EXTRA_IMAGES
import com.nguyenhoanglam.imagepicker.model.Config.RC_PICK_IMAGES
import com.nguyenhoanglam.imagepicker.model.Image
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_create_publication.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import kotlin.random.Random


class CreatePublicationActivity : AppCompatActivity() {

    private val publicationRepository: PublicationRepository = PublicationRepository()

    private val registerViewModel: RegisterViewModel by viewModels {
        RegisterViewModelFactory()
    }

    private val healthViewModel: HealthViewModel by viewModels {
        HealthViewModelFactory()
    }

    private val descriptionViewModel: DescriptionViewModel by viewModels {
        DescriptionViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_publication)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var binding: ActivityCreatePublicationBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_publication)
        binding.registerViewModel = registerViewModel
        binding.healthViewModel = healthViewModel
        binding.descriptionViewModel = descriptionViewModel
    }

    fun searchPhoto(view: View) {
        ImagePicker.with(this)
                .setCameraOnly(false)
                .setShowCamera(false)
                .setMaxSize(1080)
                .start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_PICK_IMAGES && resultCode == Activity.RESULT_OK && data != null) {

            val images = data.getParcelableArrayListExtra<Image>(EXTRA_IMAGES)
            if (images != null) {
                if (images.isNotEmpty()) {
                    photo_animal.setImageURI(Uri.parse(images.first().path))
                    registerViewModel.image = images[0].path
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun createMultipartBody (): MultipartBody.Part {
        var image = registerViewModel.image
        var file = File(image)
        val reqFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
        return MultipartBody.Part.createFormData("image", file.name, reqFile)
    }

    fun save(view: View) {
        val publication = PublicationOutputDTO(registerViewModel, healthViewModel, descriptionViewModel)
        GlobalScope.launch {
            if (registerViewModel.image != null) {
                var body = createMultipartBody()
                var response = publicationRepository.save(publication, body)
                if (response.isSuccessful) {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "Publicação criada com sucesso!", Toast.LENGTH_LONG).show()
                    }
                    finish()
                } else {
                    var errorMessage = Gson().fromJson(response.errorBody()!!.charStream(), ErrorMessage::class.java).message
                    runOnUiThread {
                        Toast.makeText(applicationContext, errorMessage, Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                runOnUiThread {
                    Toast.makeText(applicationContext, "Imagem é obrigatório", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
