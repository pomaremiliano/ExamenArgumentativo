package com.example.kotlin.a01709338_examenargumentativo.framework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.a01709338_examenargumentativo.domain.Domain
import com.example.kotlin.a01709338_examenargumentativo.data.network.ApiRepository
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel (private val repository: ApiRepository) : ViewModel() {
    val _data = MutableLiveData<ApiObject?>()
    val data = Domain()

    fun getAllData() {
        viewModelScope.launch (Dispatchers.IO) {
            val result: ApiObject? = repository.getAllData()
            _data.postValue(result)
        }
    }
}