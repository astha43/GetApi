package com.example.apidemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apidemo.model.DataModel
import com.example.apidemo.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository): ViewModel() {

    val dataList = MutableLiveData<DataModel>()
    val errorMessage = MutableLiveData<String>()

    fun getResult(){
        val response = repository.getResult()
        response.enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                dataList.postValue(response.body())
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}