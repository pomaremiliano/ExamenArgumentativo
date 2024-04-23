package com.example.kotlin.a01709338_examenargumentativo.data.network

import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiObject
import com.example.kotlin.a01709338_examenargumentativo.domain.Domain

class ApiRepository{

    private val apiClient = ApiClient()

    suspend fun getAllData (): ApiObject? {
        return apiClient.getAllData()
    }


}
