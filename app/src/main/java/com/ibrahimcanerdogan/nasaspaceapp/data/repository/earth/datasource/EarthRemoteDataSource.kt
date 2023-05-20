package com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth.datasource

import com.ibrahimcanerdogan.nasaspaceapp.model.earth.Earth
import retrofit2.Response

interface EarthRemoteDataSource {

    suspend fun getEarthDataFromRemote(todayDate : String) : Response<Earth>

}