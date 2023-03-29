package com.ibrahimcanerdogan.nasaspaceapp.view.marsrover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.nasaspaceapp.data.api.APIService
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.GetMarsRoverUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.UpdateMarsRoverUseCase

class MarsRoverViewModelFactory(
    private val getMarsRoverUseCase: GetMarsRoverUseCase,
    private val updateMarsRoverUseCase: UpdateMarsRoverUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarsRoverViewModel::class.java)) {
            return MarsRoverViewModel(getMarsRoverUseCase, updateMarsRoverUseCase) as T
        }
        throw IllegalArgumentException("ViewModel Not Found!")
    }
}