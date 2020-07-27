package com.example.ysc.cathayzoodemo.ui.plant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ysc.cathayzoodemo.data.PlantData
import com.example.ysc.cathayzoodemo.repository.plant.PlantListRepository

class PlantViewModel(plantListRepository: PlantListRepository, areaName: String, plantName: String) : ViewModel() {
    private val _plant = MutableLiveData<PlantData>().apply {
        value = plantListRepository.getPlant(areaName, plantName)
    }
    val plant = _plant
}