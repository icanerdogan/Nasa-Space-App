package com.ibrahimcanerdogan.nasaspaceapp.domain.earth.repository

import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail

interface EarthRepository {

    suspend fun getEarthDataFromRepository(todayDate : String) : List<EarthDetail>?

}