package com.example.ysc.cathayzoodemo.repository.area

import android.content.res.Resources
import android.util.Log
import com.example.ysc.cathayzoodemo.R
import com.example.ysc.cathayzoodemo.data.AreaData

object AreaListRemote {

    fun get(resources: Resources):MutableList<AreaData> {

        var areaList:MutableList<AreaData> = mutableListOf()

        val buffReader = resources.openRawResource(R.raw.area).bufferedReader()
        var line = buffReader.readLine()
        while (line!=null){
            var words = line.split(",").toTypedArray()
            //temp sol to ignore title line
            if(!words[0].startsWith("E_")) {
                var areaData = AreaData(words[0], words[2], words[3], words[4], words[5], words[7])
                areaList.add(areaData)

                Log.d("ysc", "name = ${areaData.id}")
                Log.d("ysc", "name = ${areaData.name}")
                Log.d("ysc", "imgUrl = ${areaData.img_url}")
                Log.d("ysc", "info = ${areaData.info}")
                Log.d("ysc", "info = ${areaData.memo}")
                Log.d("ysc", "url = ${areaData.url}")
            }
            line = buffReader.readLine()
        }
        buffReader.close()

        return areaList
    }

}