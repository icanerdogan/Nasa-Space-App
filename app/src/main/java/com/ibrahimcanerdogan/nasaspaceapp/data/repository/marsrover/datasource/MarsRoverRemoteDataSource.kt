package com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasource

import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRover
import retrofit2.Response

interface MarsRoverRemoteDataSource {

    suspend fun getMarsRoverDataFromRemote(page : Int) : Response<MarsRover>
}