package com.andromeda.belajarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andromeda.belajarretrofit.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    private lateinit var mainAdapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
        getDataFromApi()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)

        mainAdapter = MainAdapter(arrayListOf())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mainAdapter
        }
    }

    private fun getDataFromApi() {
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = View.VISIBLE

        ApiService.endpoint.getPhotos()
            .enqueue(object : Callback<MainModel> {
                override fun onResponse(
                    call: Call<MainModel>,
                    response: Response<MainModel>
                ) {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
//                        printLog(result.toString())
                        showData(response.body()!!)
                    }

                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    printLog(t.toString())
                }

            })
    }

    private fun showData(data: MainModel) {
        val results = data.result
        mainAdapter.setData(results)
//        for (photo in results) {
//            printLog("title: ${photo.title}")
//        }
    }

    private fun printLog(message: String) {
        Log.d(TAG, message)
    }
}