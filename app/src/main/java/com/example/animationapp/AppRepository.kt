package com.example.animationapp

import com.example.animationapp.Model.Pagination

class AppRepository {
    suspend fun getData(giphyApiKey: String,pagination: Int)=RetrofitInstance.memeApi.getData(giphyApiKey,pagination)
}