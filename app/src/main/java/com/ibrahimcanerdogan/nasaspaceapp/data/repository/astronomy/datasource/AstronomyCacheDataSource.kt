package com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource

import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

interface AstronomyCacheDataSource {
    suspend fun getAstronomyDataFromCache() : List<Astronomy>
    suspend fun saveAstronomyDataToCache(astronomyData : List<Astronomy>)
}