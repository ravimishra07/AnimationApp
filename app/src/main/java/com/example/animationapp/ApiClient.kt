package com.example.animationapp

import com.example.animationapp.Model.Data
import com.example.animationapp.Model.GifData
import com.example.animationapp.Model.Pagination
import com.google.android.gms.common.api.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("v1/gifs/trending")
    suspend fun getData(
        @Query("api_key") giphyApiKey: String?,
        @Query("limit") pagination: Int?
    ):Response<GifData>

 }