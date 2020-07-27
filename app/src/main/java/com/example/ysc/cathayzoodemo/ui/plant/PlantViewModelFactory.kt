package com.example.ysc.cathayzoodemo.ui.plant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ysc.cathayzoodemo.repository.plant.PlantListRepository

class PlantViewModelFactory (
    private val plantListRepository: PlantListRepository,
    private val areaName: String,
    private val plantName: String
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlantViewModel(plantListRepository, areaName, plantName) as T
    }
}