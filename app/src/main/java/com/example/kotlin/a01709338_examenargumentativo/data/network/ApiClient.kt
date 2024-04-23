package com.example.kotlin.a01709338_examenargumentativo.data.network

import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiData
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiObject

class ApiClient {
    private val apiService: ApiService = NetworkModuleDI.makeRetrofitService()
    suspend fun getAllData(): ApiObject {
        return try {
            apiService.getAllData()
        } catch (e: Exception) {
            e.printStackTrace()
            ApiObject(
                ApiData()
            )
        }

    }
}