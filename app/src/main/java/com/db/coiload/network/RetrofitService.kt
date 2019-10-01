package com.db.coiload.network

import com.db.coiload.models.Photo
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("v2/list")
    fun getPhotos(): Call<List<Photo>>
}