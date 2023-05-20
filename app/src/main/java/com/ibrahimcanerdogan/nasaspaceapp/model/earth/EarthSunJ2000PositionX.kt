package com.ibrahimcanerdogan.nasaspaceapp.model.earth

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "earth_sun_position")
data class EarthSunJ2000PositionX(
    @PrimaryKey(autoGenerate = true)
    val dataId: Int,
    @SerializedName("x")
    val x: Double,
    @SerializedName("y")
    val y: Double,
    @SerializedName("z")
    val z: Double
)