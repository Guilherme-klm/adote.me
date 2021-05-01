package com.example.adoteme.viewmodel

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.adoteme.model.Publication
import com.example.adoteme.repository.PublicationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageViewModel(private val repository: PublicationRepository) : BaseViewModel() {

    var publicationList: List<Publication> = listOf()

    var listLocalization = listOf("state", "city", "neighborhood")

    @Bindable
    var positionListLocalization = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.positionListLocalization)
        }

    @Bindable
    var valueLocalization = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.valueLocalization)
        }

    @Bindable
    var imageNotFount = View.VISIBLE
        set(value) {
            field = value
            notifyPropertyChanged(BR.imageNotFount)
        }

    @Bindable
    var textNotFound = View.VISIBLE
        set(value) {
            field = value
            notifyPropertyChanged(BR.textNotFound)
        }

    var reloadPublication : MutableLiveData<Boolean> = MutableLiveData(false)

    fun selectPositionListLocalization(position: Int) {
        positionListLocalization = position
    }

    fun search() {
        viewModelScope.launch(Dispatchers.IO) {

            if(valueLocalization.isNotEmpty()) {
                var publicationResponse = repository.getPublicationsByLocalization(listLocalization[positionListLocalization], valueLocalization)
                if (publicationResponse.isSuccessful) {
                    publicationList = publicationResponse.body()!!
                    textNotFound = View.GONE
                    imageNotFount = View.GONE
                } else {
                    textNotFound = View.VISIBLE
                    imageNotFount = View.VISIBLE
                    publicationList = listOf()
                }
            }
            reloadPublication.postValue(true)
        }
    }
}