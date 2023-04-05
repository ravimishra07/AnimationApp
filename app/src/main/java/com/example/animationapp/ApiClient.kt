package com.example.animationapp

import com.example.animationapp.Model.GifData
import com.example.animationapp.Model.Pagination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("v1/gifs/trending")
    fun getData(
        @Query("api_key") giphyApiKey: String?,
        @Query("limit") pagination: Int?
    ): Call<GifData>

 }