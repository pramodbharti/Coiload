package com.db.coiload

import com.db.coiload.network.getRetrofitClient

class PhotoRepository {

    suspend fun getPhotos() = getRetrofitClient(BASE_URL).getPhotos()
}