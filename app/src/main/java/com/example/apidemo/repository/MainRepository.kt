package com.example.apidemo.repository

import com.example.apidemo.api.RetrofitService

class MainRepository(private val retrofitService: RetrofitService) {

    fun getResult() = retrofitService.getResult()
}