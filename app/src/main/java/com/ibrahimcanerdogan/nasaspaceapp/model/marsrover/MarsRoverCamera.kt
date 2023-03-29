package com.ibrahimcanerdogan.nasaspaceapp.model.marsrover

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("marsrovercamera")
data class MarsRoverCamera(
    @PrimaryKey(autoGenerate = true)
    val cameraId: Int? = null,
    @SerializedName("name")
    val cameraName: String?,
    @SerializedName("full_name")
    val cameraFullName: String?
)
