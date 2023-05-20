package com.ibrahimcanerdogan.nasaspaceapp.view.earth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ibrahimcanerdogan.nasaspaceapp.domain.earth.usecase.GetEarthUseCase

class EarthViewModel(
    private val getEarthUseCase: GetEarthUseCase
) : ViewModel() {

    fun getEarthData(todayDate : String) = liveData {
        val earthList = getEarthUseCase.execute(todayDate)
        emit(earthList)
    }
}