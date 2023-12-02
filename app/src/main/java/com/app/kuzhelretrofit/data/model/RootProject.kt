package com.app.kuzhelretrofit.data.model

import com.app.kuzhelretrofit.data.model.Search
import com.google.gson.annotations.SerializedName


data class RootProject(
    @SerializedName("Search") var Search: ArrayList<Search> = arrayListOf(),
    @SerializedName("totalResults") var totalResults: String? = null,
    @SerializedName("Response") var Response: String? = null
)