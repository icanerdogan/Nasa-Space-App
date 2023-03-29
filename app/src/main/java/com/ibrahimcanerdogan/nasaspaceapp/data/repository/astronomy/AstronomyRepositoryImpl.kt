package com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy

import android.util.Log
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyCacheDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyRemoteDataSource
import com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.repository.AstronomyRepository
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

class AstronomyRepositoryImpl(
    private val astronomyRemoteDataSource: AstronomyRemoteDataSource,
    private val astronomyLocalDataSource: AstronomyLocalDataSource,
    private val astronomyCacheDataSource: AstronomyCacheDataSource
) : AstronomyRepository {

    override suspend fun getAstronomyDataFromRepository(): List<Astronomy>? {
        return getAstronomyDataFromCache()
    }

    override suspend fun updateAstronomyDataFromRepository(): List<Astronomy>? {
        val newAstronomyData = getAstronomyDataFromAPI()
        astronomyLocalDataSource.clearAstronomyDataFromLocal()
        astronomyLocalDataSource.saveAstronomyDataToLocal(newAstronomyData)
        astronomyCacheDataSource.saveAstronomyDataToCache(newAstronomyData)
        return newAstronomyData
    }

    private suspend fun getAstronomyDataFromAPI() : List<Astronomy> {
        var astronomyList : List<Astronomy> = listOf()
        try {
            val response = astronomyRemoteDataSource.getAstronomyDataFromRemote()
            val body = response.body()
            if (body != null) {
                astronomyList = body
            }
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }
        return astronomyList
    }

    private suspend fun getAstronomyDataFromDB() : List<Astronomy> {
        var astronomyList : List<Astronomy> = listOf()
        try {
            astronomyList = astronomyLocalDataSource.getAstronomyDataFromLocal()
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (astronomyList.isNotEmpty()) {
            return astronomyList
        } else {
            astronomyList = getAstronomyDataFromAPI()
            astronomyLocalDataSource.saveAstronomyDataToLocal(astronomyList)
        }

        return astronomyList
    }

    private suspend fun getAstronomyDataFromCache() : List<Astronomy> {
        lateinit var astronomyList : List<Astronomy>

        try {
            astronomyList = astronomyCacheDataSource.getAstronomyDataFromCache()
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (astronomyList.isNotEmpty()) {
            return astronomyList
        } else {
            astronomyList = getAstronomyDataFromDB()
            astronomyCacheDataSource.saveAstronomyDataToCache(astronomyList)
        }
        return astronomyList
    }

    companion object {
        private val TAG : String = AstronomyRepositoryImpl::class.java.simpleName
    }
}