package com.example.ysc.cathayzoodemo.ui.area

import android.opengl.Visibility
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ysc.cathayzoodemo.api.PlantApi
import com.example.ysc.cathayzoodemo.data.AreaData
import com.example.ysc.cathayzoodemo.data.PlantData
import com.example.ysc.cathayzoodemo.repository.area.AreaListRepository
import com.example.ysc.cathayzoodemo.repository.plant.PlantListRemote
import com.example.ysc.cathayzoodemo.repository.plant.PlantListRepository

class AreaViewModel (
    areaListRepository: AreaListRepository,
    id:String,
    plantListRepository: PlantListRepository
): ViewModel() {

    private val _area = MutableLiveData<AreaData>().apply {
        areaListRepository.getById(id);
    }
    var area = areaListRepository.getById(id)

    var plants = plantListRepository.getPlants(area.name)

//    var listVisible  = MutableLiveData<Int>().apply{
//        View.GONE
//    }
}