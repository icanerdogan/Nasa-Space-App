package com.ibrahimcanerdogan.nasaspaceapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail

@Dao
interface EarthDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEarthData(astronomyList : List<EarthDetail>)

    @Query("DELETE FROM earthdetail")
    suspend fun deleteAllEarthData()

    @Query("SELECT * FROM earthdetail")
    suspend fun getAllEarthData() : List<EarthDetail>
}