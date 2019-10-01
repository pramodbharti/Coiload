package com.db.coiload

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.db.coiload.models.Photo
import com.db.coiload.network.getRetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoRepository {

    fun getPhotos(): LiveData<List<Photo>> {
        val liveData = MutableLiveData<List<Photo>>()
        getRetrofitClient(BASE_URL).getPhotos().enqueue(object : Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    liveData.value = response.body()
                }
            }
        })
        return liveData
    }
}