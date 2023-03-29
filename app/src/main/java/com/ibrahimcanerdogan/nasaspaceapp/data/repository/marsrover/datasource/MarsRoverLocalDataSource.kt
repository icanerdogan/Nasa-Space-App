package com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasource

import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail

interface MarsRoverLocalDataSource {

    suspend fun getMarsRoverDataFromLocal() : List<MarsRoverDetail>
    suspend fun saveMarsRoverDataToLocal(marsRoverData : List<MarsRoverDetail>)
    suspend fun clearMarsRoverDataFromLocal()
}