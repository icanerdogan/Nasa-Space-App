package com.ibrahimcanerdogan.nasaspaceapp.view.marsrover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.GetMarsRoverUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.UpdateMarsRoverUseCase

class MarsRoverViewModel(
    private val getMarsRoverUseCase : GetMarsRoverUseCase,
    private val updateMarsRoverUseCase: UpdateMarsRoverUseCase
) : ViewModel() {

    fun getMarsRoverData(page : Int) = liveData {
        val marsRoveData = getMarsRoverUseCase.execute(page)
        emit(marsRoveData)
    }

    fun updateMarsRoverData(page : Int) = liveData {
        val marsRoveData = updateMarsRoverUseCase.execute(page)
        emit(marsRoveData)
    }
}