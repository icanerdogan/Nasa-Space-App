package com.ibrahimcanerdogan.nasaspaceapp.domain.usecase

import com.ibrahimcanerdogan.nasaspaceapp.domain.repository.AstronomyRepository
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

class UpdateAstronomyUseCase(
    private val astronomyRepository: AstronomyRepository
) {

    suspend fun execute() : List<Astronomy>? = astronomyRepository.updateAstronomyDataFromRepository()
}