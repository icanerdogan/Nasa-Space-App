package com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource

import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import retrofit2.Response

interface AstronomyLocalDataSource {
    suspend fun getAstronomyDataFromLocal() : List<Astronomy>
    suspend fun saveAstronomyDataToLocal(astronomyData : List<Astronomy>)
    suspend fun clearAstronomyDataFromLocal()
}