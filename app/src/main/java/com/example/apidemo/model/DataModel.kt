package com.example.apidemo.model

data class DataModel(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: ArrayList<Result>
)

data class Result(
    val name: String,
    val url: String
)