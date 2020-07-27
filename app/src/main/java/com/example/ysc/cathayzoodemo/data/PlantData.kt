package com.example.ysc.cathayzoodemo.data

import com.google.gson.annotations.SerializedName

data class PlantData (
    @SerializedName("\uFEFFF_Name_Ch") val name_ch: String,
    @SerializedName("F_Name_Latin") val name_latin: String,
    @SerializedName("F_AlsoKnown") val known: String,
    @SerializedName("F_Brief") val brief: String,
    @SerializedName("F_Feature") val feature: String,
    @SerializedName("F_Function＆Application") val function: String,
    @SerializedName("F_Update") val update: String,
    @SerializedName("F_Pic01_URL") val img_url: String=""
)

data class PlantResults(
    @SerializedName("results") val results: List<PlantData>
)

data class PlantResponse(
    @SerializedName("result") val result: PlantResults
)