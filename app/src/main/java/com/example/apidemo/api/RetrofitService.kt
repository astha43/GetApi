package com.example.apidemo.api

import com.example.apidemo.model.DataModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("v2/generation/?limit=10")
    fun getResult() : Call<DataModel>

    companion object{
        var retrofitService : RetrofitService? =null

        fun getInstance() : RetrofitService {

            if (retrofitService == null){

                val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BODY)

                val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

                val retrofit = Retrofit.Builder().client(okHttpClient)
                    .baseUrl("https://pokeapi.co/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}