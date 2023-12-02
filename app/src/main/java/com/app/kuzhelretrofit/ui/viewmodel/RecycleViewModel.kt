package com.app.kuzhelretrofit.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.app.kuzhelretrofit.data.model.RootProject
import com.app.kuzhelretrofit.data.retrofit.Common
import com.app.kuzhelretrofit.data.retrofit.RetrofitServices

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecycleViewModel(val context: Context) : ViewModel() {
    private var mService: RetrofitServices = Common.retrofitService
    val projectsLiveData: MutableLiveData<RootProject> = MutableLiveData()
    init {
        mService.getMovieList(
            "aabbadeb",
            "spider-man",

            ).enqueue(object : Callback<RootProject> {
            override fun onFailure(call: Call<RootProject>, t: Throwable) {
                Toast.makeText(context, "Network error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<RootProject>,
                response: Response<RootProject>
            ) {
                projectsLiveData.value=response.body()

            }
        })

    }
}