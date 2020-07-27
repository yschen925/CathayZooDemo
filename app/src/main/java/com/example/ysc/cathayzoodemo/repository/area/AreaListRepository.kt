package com.example.ysc.cathayzoodemo.repository.area

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.ysc.cathayzoodemo.data.AreaData

class AreaListRepository(private val resources:Resources) {

    fun get():MutableList<AreaData>{
        if(AreaListLocal.areaList.size==0) {
            AreaListLocal.areaList = AreaListRemote.get(resources)
        }
        return AreaListLocal.areaList
    }

    fun getById(id:String):AreaData{
        if(AreaListLocal.areaList.size==0) {
            AreaListLocal.areaList = AreaListRemote.get(resources)
        }
        return AreaListLocal.areaList.first { it.id == id }
    }
}