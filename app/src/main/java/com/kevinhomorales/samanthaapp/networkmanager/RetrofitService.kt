package com.kevinhomorales.samanthaapp.networkmanager

import com.kevinhomorales.samanthaapp.main.model.comments.Comments
import com.kevinhomorales.samanthaapp.sample.model.posts.Posts
import com.kevinhomorales.samanthaapp.main.model.users.Users
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("users")
    suspend fun getUsers(): Users
    @GET("posts")
    suspend fun getPosts(): Posts
    @GET("comments")
    suspend fun getComments(): Comments
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}