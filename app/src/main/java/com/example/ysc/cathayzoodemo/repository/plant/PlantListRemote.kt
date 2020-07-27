package com.example.ysc.cathayzoodemo.repository.plant

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ysc.cathayzoodemo.api.PlantApi
import com.example.ysc.cathayzoodemo.data.PlantData
import com.example.ysc.cathayzoodemo.data.PlantResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PlantListRemote {

    fun getPlants(areaName:String): LiveData<List<PlantData>> {
        //hardcode
        val options = mapOf<String, String>("scope" to "resourceAquire", "q" to areaName)
        val plantApiService = PlantApi.create()

        val plantListLiveData = MutableLiveData<List<PlantData>>()
        plantApiService.getPlantsByArea(options).enqueue(
            object: Callback<PlantResponse> {
                override fun onResponse(
                    call: Call<PlantResponse>,
                    response: Response<PlantResponse>
                ) {

                    val body = response.body()
                    Log.d("ysc","net body = ${body.toString()}")

                    plantListLiveData.value = response.body()?.result?.results
                }

                override fun onFailure(call: Call<PlantResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                    Log.d("ysc","net fail respond")
                }
            }
        )

        return plantListLiveData
    }
}