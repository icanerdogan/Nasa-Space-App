package com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth.datasourceImpl

import com.ibrahimcanerdogan.nasaspaceapp.data.api.APIService
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth.datasource.EarthRemoteDataSource
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.Earth
import retrofit2.Response

class EarthRemoteDataSourceImpl(
    private val apiService: APIService,
    private val apiKey : String
) : EarthRemoteDataSource {

    override suspend fun getEarthDataFromRemote(todayDate: String): Response<Earth> {
        return apiService.getEarthFromAPI(todayDate, apiKey)
    }
}