package com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasourceImpl

import com.ibrahimcanerdogan.nasaspaceapp.data.api.APIService
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasource.MarsRoverRemoteDataSource
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRover
import retrofit2.Response


class MarsRoverRemoteDataSourceImpl(
    private val apiService: APIService,
    private val apiKey : String
) : MarsRoverRemoteDataSource {

    override suspend fun getMarsRoverDataFromRemote(page : Int): Response<MarsRover> {
        return apiService.getMarsRoverDataFromAPI(page, apiKey)
    }
}