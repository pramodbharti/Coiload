package com.db.coiload

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class PhotoViewModel : ViewModel() {
    private val repository: PhotoRepository = PhotoRepository()

    //Using coroutines
    val photos = liveData(Dispatchers.IO) {
        val fetchPhotos = repository.getPhotos()
        emit(fetchPhotos)
    }
}