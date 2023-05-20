package com.ibrahimcanerdogan.nasaspaceapp.view.earth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.nasaspaceapp.domain.earth.usecase.GetEarthUseCase

class EarthViewModelFactory(
    private val getEarthUseCase: GetEarthUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EarthViewModel::class.java)) {
            return EarthViewModel(getEarthUseCase) as T
        }
        throw IllegalArgumentException("ViewModel Not Found!")
    }
}