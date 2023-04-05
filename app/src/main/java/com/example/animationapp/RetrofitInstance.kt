package com.example.animationapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(" https://api.giphy.com/").addConverterFactory(GsonConverterFactory
            .create()).build()
    }
    val apiInterface by lazy {
        retrofit.create(ApiClient::class.java)
    }
}