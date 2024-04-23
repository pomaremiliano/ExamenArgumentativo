package com.example.kotlin.a01709338_examenargumentativo.data.network

import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiData
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiDataItem
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiObject
import com.example.kotlin.a01709338_examenargumentativo.domain.Domain
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("domain_info") suspend fun getAllData(): ApiObject
}