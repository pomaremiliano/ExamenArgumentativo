package com.example.kotlin.a01709338_examenargumentativo.domain

import com.example.kotlin.a01709338_examenargumentativo.data.network.ApiRepository
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiObject

class Domain {
private val repository: ApiRepository = ApiRepository()
    suspend operator fun invoke(
    ): ApiObject? = repository.getAllData()
}

