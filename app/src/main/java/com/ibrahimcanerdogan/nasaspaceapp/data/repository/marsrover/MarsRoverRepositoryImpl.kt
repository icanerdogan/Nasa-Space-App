package com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover

import android.util.Log
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasource.MarsRoverLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasource.MarsRoverRemoteDataSource
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.repository.MarsRoverRepository
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail

class MarsRoverRepositoryImpl(
    private val marsRoverRemoteDataSource: MarsRoverRemoteDataSource,
    private val marsRoverLocalDataSource: MarsRoverLocalDataSource
) : MarsRoverRepository {

    override suspend fun getMarsRoverDataFromRepository(page : Int) : List<MarsRoverDetail>? {
        return getMarsRoverDataFromDB(page)
    }

    override suspend fun updateMarsRoverDataFromRepository(page : Int): List<MarsRoverDetail>? {
        val newAstronomyData = getMarsRoverDataFromAPI(page)
        marsRoverLocalDataSource.clearMarsRoverDataFromLocal()
        marsRoverLocalDataSource.saveMarsRoverDataToLocal(newAstronomyData)
        return newAstronomyData
    }

    private suspend fun getMarsRoverDataFromAPI(page : Int) : List<MarsRoverDetail> {
        var marsRoverDetail : List<MarsRoverDetail> = listOf()
        try {
            val response = marsRoverRemoteDataSource.getMarsRoverDataFromRemote(page)
            val body = response.body()
            if (body != null) {
                marsRoverDetail = body.dataMarsRover
            }
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }
        return marsRoverDetail
    }

    private suspend fun getMarsRoverDataFromDB(page : Int) : List<MarsRoverDetail> {
        var marsRoverDetail : List<MarsRoverDetail> = listOf()
        try {
            marsRoverDetail = marsRoverLocalDataSource.getMarsRoverDataFromLocal()
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (marsRoverDetail.isNotEmpty()) {
            return marsRoverDetail
        } else {
            marsRoverDetail = getMarsRoverDataFromAPI(page)
            marsRoverLocalDataSource.saveMarsRoverDataToLocal(marsRoverDetail)
        }

        return marsRoverDetail
    }


    companion object {
        private val TAG : String = MarsRoverRepositoryImpl::class.java.simpleName
    }
}