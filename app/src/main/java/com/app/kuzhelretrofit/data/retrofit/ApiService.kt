package com.app.kuzhelretrofit.data.retrofit

import com.app.kuzhelretrofit.data.model.RootProject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


val myUrl = "https://www.omdbapi.com/"

object RetrofitClient {
    private var retrofit: Retrofit? = null
    fun getClient(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(myUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}

interface RetrofitServices {
    @GET(".")
    fun getMovieList(
        @Query("apikey") apsId: String,
        @Query("s") campaign: String?,
    ): Call<RootProject>
}