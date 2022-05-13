package com.example.photogalery

import retrofit2.Call
import retrofit2.http.GET

interface FlickApi
{
    @GET("/")
    fun fetchContents():Call<String>
}