package com.example.ysc.cathayzoodemo.repository.plant

import androidx.lifecycle.LiveData
import com.example.ysc.cathayzoodemo.data.PlantData

object PlantListLocal{
    var plantsMap = mutableMapOf<String, LiveData<List<PlantData>>>()
}