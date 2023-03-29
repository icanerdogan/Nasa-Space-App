package com.ibrahimcanerdogan.nasaspaceapp.model.marsrover

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "marsroverdetail")
data class MarsRoverDetail(
    @PrimaryKey
    @SerializedName("id")
    val detailId: Int,
    @SerializedName("img_src")
    val detailImageSource: String,
    @SerializedName("earth_date")
    val detailEarthDate: String,
    @SerializedName("rover")
    val detailRover: MarsRoverData,
    @SerializedName("camera")
    val detailCamera: MarsRoverCamera
)