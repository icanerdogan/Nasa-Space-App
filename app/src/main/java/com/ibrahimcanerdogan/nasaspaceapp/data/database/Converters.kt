package com.ibrahimcanerdogan.nasaspaceapp.data.database

import androidx.room.TypeConverter
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.*
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverCamera
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverData

class Converters {
    @TypeConverter
    fun fromMarsRoverCamera(source: MarsRoverCamera): String? {
        return source.cameraName
    }

    @TypeConverter
    fun toMarsRoverCamera(data: String): MarsRoverCamera {
        return MarsRoverCamera(cameraName = data, cameraFullName = data)
    }

    @TypeConverter
    fun fromMarsRoverData(source: MarsRoverData): String {
        return source.roverName!!
    }

    @TypeConverter
    fun toMarsRoverData(data: String): MarsRoverData {
        return MarsRoverData(roverName = data, roverLandingDate = data, roverLaunchDate = data)
    }
    @TypeConverter
    fun fromStringEarthCentroidCoordinates(value: String): EarthCentroidCoordinates {
        val (lat, lon) = value.split(",")
        return EarthCentroidCoordinates(0, lat = lat.toDouble(), lon = lon.toDouble())
    }

    @TypeConverter
    fun toStringEarthCentroidCoordinates(value: EarthCentroidCoordinates): String {
        return "${value.lat},${value.lon}"
    }

    @TypeConverter
    fun fromStringEarthAttitudeQuaternions(value: String): EarthAttitudeQuaternions {
        val (q0, q1, q2, q3) = value.split(",")
        return EarthAttitudeQuaternions(0 , q0 = q0.toDouble(), q1 = q1.toDouble(), q2 = q2.toDouble(), q3 = q3.toDouble())
    }

    @TypeConverter
    fun toStringEarthAttitudeQuaternions(value: EarthAttitudeQuaternions): String {
        return "${value.q0},${value.q1},${value.q2},${value.q3}"
    }


    @TypeConverter
    fun fromStringEarthDscovrJ2000PositionX(value: String): EarthDscovrJ2000PositionX {
        val (x, y, z) = value.split(",")
        return EarthDscovrJ2000PositionX(0, x = x.toDouble(), y = y.toDouble(), z = z.toDouble())
    }

    @TypeConverter
    fun toStringEarthDscovrJ2000PositionX(value: EarthDscovrJ2000PositionX): String {
        return "${value.x},${value.y},${value.z}"
    }

    @TypeConverter
    fun fromStringEarthLunarJ2000PositionX(value: String): EarthLunarJ2000PositionX {
        val (x, y, z) = value.split(",")
        return EarthLunarJ2000PositionX(0, x.toDouble(), y.toDouble(), z.toDouble())
    }

    @TypeConverter
    fun toStringEarthLunarJ2000PositionX(value: EarthLunarJ2000PositionX): String {
        return "${value.x},${value.y},${value.z}"
    }

    @TypeConverter
    fun fromStringEarthSunJ2000PositionX(value: String): EarthSunJ2000PositionX {
        val (x, y, z) = value.split(",")
        return EarthSunJ2000PositionX(0, x.toDouble(), y.toDouble(), z.toDouble())
    }

    @TypeConverter
    fun toStringEarthSunJ2000PositionX(value: EarthSunJ2000PositionX): String {
        return "${value.x},${value.y},${value.z}"
    }
}
