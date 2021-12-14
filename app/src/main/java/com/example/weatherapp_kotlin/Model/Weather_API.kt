package com.example.weatherapp_kotlin.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Weather_API {
    @GET("data/2.5/find?")
    fun getCurrentWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("cnt") cnt: String,
        @Query("appid") app_id: String
    ): Call<Weather_response>

}