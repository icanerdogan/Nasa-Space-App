package com.ibrahimcanerdogan.nasaspaceapp.model.earth

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "earth_attitude_quaternions")
data class EarthAttitudeQuaternions(
    @PrimaryKey(autoGenerate = true)
    val dataId: Int,
    @SerializedName("q0")
    val q0: Double,
    @SerializedName("q1")
    val q1: Double,
    @SerializedName("q2")
    val q2: Double,
    @SerializedName("q3")
    val q3: Double
)