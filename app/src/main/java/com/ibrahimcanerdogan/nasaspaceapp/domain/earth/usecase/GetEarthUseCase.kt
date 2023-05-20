package com.ibrahimcanerdogan.nasaspaceapp.domain.earth.usecase

import com.ibrahimcanerdogan.nasaspaceapp.domain.earth.repository.EarthRepository
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail

class GetEarthUseCase(
    private val earthRepository: EarthRepository
) {
    suspend fun execute(todayDate : String) : List<EarthDetail>? = earthRepository.getEarthDataFromRepository(todayDate)
}