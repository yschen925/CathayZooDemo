package com.example.ysc.cathayzoodemo.api

import android.content.res.Resources
import android.provider.Settings.Global.getString
import com.example.ysc.cathayzoodemo.R
import com.example.ysc.cathayzoodemo.data.PlantResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface PlantApi {

    @GET("api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14")
    fun getPlantsByArea(@QueryMap options:Map<String, String> ): Call<PlantResponse>

    companion object PlantApiService {
        private const val url:String = "https://data.taipei/"
        fun create():PlantApi{
            var retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
//            var retrofit = Retrofit.Builder()
//                .baseUrl(Resources.getSystem().getString(R.string.zoo_plant_api))
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()

            return retrofit.create(PlantApi::class.java)
        }

    }
}