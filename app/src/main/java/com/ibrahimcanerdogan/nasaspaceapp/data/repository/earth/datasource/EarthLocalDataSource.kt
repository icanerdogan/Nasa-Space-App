package com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth.datasource

import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail

interface EarthLocalDataSource {

    suspend fun getEarthDataFromLocal() : List<EarthDetail>
    suspend fun saveEarthDataToLocal(earthData : List<EarthDetail>)
    suspend fun clearEarthDataFromLocal()
}