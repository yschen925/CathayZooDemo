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

class PlantListRepository {

    fun getPlants(areaName:String): LiveData<List<PlantData>> {
        //TODO add cache timeout scheme
        val cache = PlantListLocal.plantsMap[areaName]
        return if(cache!=null){
            cache
        } else {
            //TODO
            val plantsLiveData = PlantListRemote.getPlants(areaName)
            PlantListLocal.plantsMap[areaName] = plantsLiveData
            plantsLiveData
        }
    }

    fun getPlant(areaName:String, plantName:String): PlantData? {
        Log.d("ysc","areaName== $areaName, plantName=$plantName")
        val cache = PlantListLocal.plantsMap[areaName]
        return if(cache!=null){
            val plant = cache.value?.find { plant -> plant.name_ch == plantName }
            Log.d("ysc","getplant== {$plant}")
            cache.value?.find { plant -> plant.name_ch == plantName }
        } else {
            //TODO
            val plantsLiveData = PlantListRemote.getPlants(areaName)
            PlantListLocal.plantsMap[areaName] = plantsLiveData
            plantsLiveData.value?.find { plant -> plant.name_ch == plantName }
        }
    }
}