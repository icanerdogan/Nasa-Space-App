package com.ibrahimcanerdogan.nasaspaceapp.data.database

import androidx.room.TypeConverter
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
}
