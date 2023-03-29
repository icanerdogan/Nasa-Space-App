package com.ibrahimcanerdogan.nasaspaceapp.model.marsrover

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("marsroverdata")
data class MarsRoverData(
    @PrimaryKey(autoGenerate = true)
    val roverId: Int? = null,
    @SerializedName("name")
    val roverName: String?,
    @SerializedName("landing_date")
    val roverLandingDate: String?,
    @SerializedName("launch_date")
    val roverLaunchDate: String?,
)
