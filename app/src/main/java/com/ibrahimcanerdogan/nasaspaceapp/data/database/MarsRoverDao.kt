package com.ibrahimcanerdogan.nasaspaceapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail

@Dao
interface MarsRoverDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMarsRoverData(astronomyList : List<MarsRoverDetail>)

    @Query("DELETE FROM marsroverdetail")
    suspend fun deleteAllMarsRoverData()

    @Query("SELECT * FROM marsroverdetail")
    suspend fun getAllMarsRoverData() : List<MarsRoverDetail>

}