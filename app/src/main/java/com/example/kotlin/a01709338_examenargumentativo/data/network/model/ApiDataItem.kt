package com.example.kotlin.a01709338_examenargumentativo.data.network.model

data class ApiDataItem(
    val expire: Int,
    val flags: Int,
    val mname: String,
    val record_type: String,
    val refresh: Int,
    val retry: Int,
    val rname: String,
    val serial: Int,
    val tag: String,
    val ttl: Int,
    val value: String
)
