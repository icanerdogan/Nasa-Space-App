package com.ibrahimcanerdogan.nasaspaceapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.*
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRover
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverCamera
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverData
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail

@Database(
    entities = [Astronomy::class,
        MarsRoverDetail::class, MarsRoverData::class, MarsRoverCamera::class,
        EarthDetail::class, EarthAttitudeQuaternions::class, EarthCentroidCoordinates::class,
        EarthDscovrJ2000PositionX::class, EarthLunarJ2000PositionX::class, EarthSunJ2000PositionX::class],
    version = 8,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class NasaDatabase : RoomDatabase() {

    abstract fun astronomyDao(): AstronomyDao
    abstract fun marsRoverDao(): MarsRoverDao
    abstract fun earthDao(): EarthDao
}