package com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource

import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import retrofit2.Response

interface AstronomyRemoteDataSource {
    suspend fun getAstronomyDataFromRemote() : Response<List<Astronomy>>
}