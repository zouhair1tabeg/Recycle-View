package com.example.api6

import retrofit2.Call
import retrofit2.http.GET

data class Smartphone(
    val id : Int,
    val nom : String,
    val prix : Double,
    val image : String
)

interface ApiService {
    @GET("/SmartphoneAPI/readAll.php")
    fun getSmatphone(): Call<List<Smartphone>>
}