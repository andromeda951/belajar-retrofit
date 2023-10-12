package com.andromeda.belajarretrofit.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("photos")
    fun getPhotos(): Call<List<MainModel>>
}