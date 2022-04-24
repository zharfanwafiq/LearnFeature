package com.zharfan.learnfeature.data.api

import com.zharfan.learnfeature.data.response.ResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getResponse():Call<List<ResponseItem>>
}