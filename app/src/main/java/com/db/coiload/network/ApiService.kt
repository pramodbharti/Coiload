package com.db.coiload.network

import com.db.coiload.models.Photo
import retrofit2.http.GET

interface ApiService {

    @GET("v2/list")
    suspend fun getPhotos(): List<Photo>
}