package com.ibrahimcanerdogan.nasaspaceapp.model.earth

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "earth_centroid_coordinates")
data class EarthCentroidCoordinates(
    @PrimaryKey(autoGenerate = true)
    val dataId: Int?,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)