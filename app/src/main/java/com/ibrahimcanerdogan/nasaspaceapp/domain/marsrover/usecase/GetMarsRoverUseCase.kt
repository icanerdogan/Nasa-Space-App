package com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase

import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.repository.MarsRoverRepository
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail

class GetMarsRoverUseCase(
    private val marsRoverRepository: MarsRoverRepository
) {
    suspend fun execute(page : Int) : List<MarsRoverDetail>? = marsRoverRepository.getMarsRoverDataFromRepository(page)
}