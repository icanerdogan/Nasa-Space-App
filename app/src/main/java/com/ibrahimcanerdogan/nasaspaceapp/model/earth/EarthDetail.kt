package com.ibrahimcanerdogan.nasaspaceapp.model.earth

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "earthdetail")
data class EarthDetail(
    @PrimaryKey
    @SerializedName("identifier")
    val earthId : Long,
    @SerializedName("caption")
    val earthCaption: String,
    @SerializedName("image")
    val earthImageCode: String,
    @SerializedName("centroid_coordinates")
    val earthCentroidCoordinates: EarthCentroidCoordinates,
    @SerializedName("dscovr_j2000_position")
    val earthDscovrJ2000Position: EarthDscovrJ2000PositionX,
    @SerializedName("attitude_quaternions")
    val earthAttitudeQuaternions: EarthAttitudeQuaternions,
    @SerializedName("lunar_j2000_position")
    val earthLunarJ2000Position: EarthLunarJ2000PositionX,
    @SerializedName("sun_j2000_position")
    val earthSunJ2000Position: EarthSunJ2000PositionX,
    @SerializedName("date")
    val earthDate: String
)