package com.db.coiload.data

import com.db.coiload.util.BASE_URL
import com.db.coiload.network.getRetrofitClient

class PhotoRepository {
    suspend fun getPhotos() = getRetrofitClient(BASE_URL).getPhotos()
}