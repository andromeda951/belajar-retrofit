package com.andromeda.belajarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.andromeda.belajarretrofit.retrofit.ApiService
import com.andromeda.belajarretrofit.retrofit.MainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        getDataFromApi()
    }

    private fun getDataFromApi() {
        ApiService.endpoint.getPhotos()
            .enqueue(object : Callback<MainModel> {
                override fun onResponse(
                    call: Call<MainModel>,
                    response: Response<MainModel>
                ) {
                    if (response.isSuccessful) {
//                        printLog(result.toString())
                        showData(response.body()!!)
                    }

                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    printLog(t.toString())
                }

            })
    }

    private fun showData(data: MainModel) {
        val results = data.result
        for (photo in results) {
            printLog("title: ${photo.title}")
        }
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }
}