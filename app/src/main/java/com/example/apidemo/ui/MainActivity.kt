package com.example.apidemo.ui

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apidemo.adapter.MainAdapter
import com.example.apidemo.api.RetrofitService
import com.example.apidemo.databinding.ActivityMainBinding
import com.example.apidemo.repository.MainRepository
import com.example.apidemo.viewmodel.MainViewModel
import com.example.apidemo.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService)))
            .get(MainViewModel::class.java)

        val recycler = binding.recyclerView
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)

        viewModel.dataList.observe(this, Observer {
            Log.d(TAG, "onCreate : $it")

            recycler.adapter =MainAdapter(this@MainActivity,it.results)

            Toast.makeText(this@MainActivity,it.results.toString(),Toast.LENGTH_SHORT).show()

        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
        })

        viewModel.getResult()
    }
}