package com.example.kotlin.a01709338_examenargumentativo.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create(GsonBuilder().create())
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

    fun makeRetrofitService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/dnslookup?domain=")
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(ApiService::class.java)
    }
}