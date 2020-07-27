package com.example.ysc.cathayzoodemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ysc.cathayzoodemo.data.AreaData
import com.example.ysc.cathayzoodemo.repository.area.AreaListRepository

class HomeViewModel (areaListRepository: AreaListRepository) : ViewModel() {

    private val _areas =  MutableLiveData<List<AreaData>>().apply {
        value = areaListRepository.get()
    }
    var areaListLiveData: MutableLiveData<List<AreaData>> = _areas
}