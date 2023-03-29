package com.ibrahimcanerdogan.nasaspaceapp.model.marsrover

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MarsRover(
    @PrimaryKey(autoGenerate = true)
    val dataId: Int,
    @SerializedName("photos")
    val dataMarsRover: List<MarsRoverDetail>
)
