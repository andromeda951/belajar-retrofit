package com.andromeda.belajarretrofit.retrofit

import com.andromeda.belajarretrofit.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("data.php")
    fun getPhotos(): Call<MainModel>
}