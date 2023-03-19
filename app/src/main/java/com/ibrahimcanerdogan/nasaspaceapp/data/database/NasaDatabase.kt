package com.ibrahimcanerdogan.nasaspaceapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

@Database(
    entities = [Astronomy::class],
    version = 1,
    exportSchema = false
)
abstract class NasaDatabase : RoomDatabase()  {

    abstract fun astronomyDao() : AstronomyDao

}