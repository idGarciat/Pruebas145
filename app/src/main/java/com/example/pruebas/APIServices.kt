package com.example.pruebas

import retrofit2.Call
import retrofit2.http.GET

interface APIServices {
    @GET("posts")
    fun listPosts(): Call<List<Posts>>
}
