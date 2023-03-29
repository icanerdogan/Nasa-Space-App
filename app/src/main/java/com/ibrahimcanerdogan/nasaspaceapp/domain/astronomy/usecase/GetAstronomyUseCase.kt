package com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.usecase

import com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.repository.AstronomyRepository
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

class GetAstronomyUseCase(
    private val astronomyRepository: AstronomyRepository
) {
    suspend fun execute() : List<Astronomy>? = astronomyRepository.getAstronomyDataFromRepository()
}