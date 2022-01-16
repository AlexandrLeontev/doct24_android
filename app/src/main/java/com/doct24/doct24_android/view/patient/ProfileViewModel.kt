package com.doct24.doct24_android.view.patient

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URI

open class ProfileViewModel : ViewModel(){
    private val _image: MutableLiveData<Uri> = MutableLiveData<Uri>()
    val image: LiveData<Uri> = _image

    fun setImage(uri: Uri) {
        _image.postValue(uri)
//        sharedPreferences.setImage(uri)
    }

    fun getImage() {
//        sharedPreferences.getImage()?.let(::setImage)
    }
}