package com.db.coiload

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.db.coiload.models.Photo

class PhotoViewModel : ViewModel() {
    private val repository: PhotoRepository = PhotoRepository()
    fun getPhotos(): LiveData<List<Photo>> = repository.getPhotos()
}