package com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth

import android.util.Log
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth.datasource.EarthLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth.datasource.EarthRemoteDataSource
import com.ibrahimcanerdogan.nasaspaceapp.domain.earth.repository.EarthRepository
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail

class EarthRepositoryImpl(
    private val earthRemoteDataSource: EarthRemoteDataSource,
    private val earthLocalDataSource: EarthLocalDataSource
) : EarthRepository {

    override suspend fun getEarthDataFromRepository(todayDate: String): List<EarthDetail>? {
        return getEarthDataFromDB(todayDate)
    }

    private suspend fun getEarthDataFromAPI(todayDate : String) : ArrayList<EarthDetail> {
        var earthDetail : ArrayList<EarthDetail> = arrayListOf()
        try {
            val response = earthRemoteDataSource.getEarthDataFromRemote(todayDate)
            val body = response.body()
            if (body != null) {
                earthDetail = body
            }
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }
        return earthDetail
    }

    private suspend fun getEarthDataFromDB(todayDate : String) : List<EarthDetail> {
        var earthDetail : List<EarthDetail> = listOf()
        try {
            earthDetail = earthLocalDataSource.getEarthDataFromLocal()
        } catch (e : Exception) {
            Log.e(TAG, e.message.toString())
        }

        if (earthDetail.isNotEmpty()) {
            return earthDetail
        } else {
            earthDetail = getEarthDataFromAPI(todayDate)
            earthLocalDataSource.saveEarthDataToLocal(earthDetail)
        }

        return earthDetail
    }


    companion object {
        private val TAG : String = EarthRepositoryImpl::class.java.simpleName
    }
}