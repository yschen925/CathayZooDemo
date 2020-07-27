package com.example.ysc.cathayzoodemo.ui.area

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ysc.cathayzoodemo.repository.area.AreaListRepository
import com.example.ysc.cathayzoodemo.repository.plant.PlantListRepository
import com.example.ysc.cathayzoodemo.ui.home.HomeViewModel

class AreaViewModelFactory (
    private val areaListRepository: AreaListRepository,
    private val id:String,
    private val plantListRepository: PlantListRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AreaViewModel(areaListRepository, id, plantListRepository) as T
    }
}