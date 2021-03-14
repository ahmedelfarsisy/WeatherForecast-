package com.iti.elfarsisy.mad41.myapplication.data.source.remote

import com.iti.elfarsisy.mad41.myapplication.data.model.WeatherData
import com.iti.elfarsisy.mad41.myapplication.helper.APP_ID
import com.iti.elfarsisy.mad41.myapplication.helper.EXCLUDE_MINUTELY
import com.iti.elfarsisy.mad41.myapplication.helper.UNITS_STANDERD
import com.iti.elfarsisy.mad41.myapplication.helper.WEATHER_BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object WeatherApi {
    fun getWeatherRetrofitClient() = Retrofit.Builder()
        .baseUrl(WEATHER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(WeatherApiServices::class.java)
}


interface WeatherApiServices {
    @GET("data/2.5/onecall")
    suspend fun fetchWeatherData(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String = EXCLUDE_MINUTELY,
        @Query("units") units: String = UNITS_STANDERD,
        @Query("lang") lang: String = "en",
        @Query("appid") appID: String = APP_ID
    ): Response<WeatherData>
}