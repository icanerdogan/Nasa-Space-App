package com.ibrahimcanerdogan.nasaspaceapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

@Dao
interface AstronomyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAstronomyData(astronomyList : List<Astronomy>)

    @Query("DELETE FROM apod")
    suspend fun deleteAllAstronomyData()

    @Query("SELECT * FROM apod")
    suspend fun getAllAstronomyData() : List<Astronomy>
}