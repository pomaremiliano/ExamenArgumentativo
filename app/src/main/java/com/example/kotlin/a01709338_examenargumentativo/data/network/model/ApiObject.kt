package com.example.kotlin.a01709338_examenargumentativo.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiObject (
    @SerializedName("data") val results: ArrayList<com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiDataItem>,
)