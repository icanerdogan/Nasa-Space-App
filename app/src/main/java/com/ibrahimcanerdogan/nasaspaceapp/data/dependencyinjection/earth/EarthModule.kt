package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.earth

import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.marsrover.MarsRoverScope
import com.ibrahimcanerdogan.nasaspaceapp.domain.earth.usecase.GetEarthUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.GetMarsRoverUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.UpdateMarsRoverUseCase
import com.ibrahimcanerdogan.nasaspaceapp.view.earth.EarthViewModelFactory
import com.ibrahimcanerdogan.nasaspaceapp.view.marsrover.MarsRoverViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class EarthModule {

    @EarthScope
    @Provides
    fun provideEarthViewModelFactory(
        getEarthUseCase: GetEarthUseCase,
    ) : EarthViewModelFactory {
        return EarthViewModelFactory(
           getEarthUseCase
        )
    }
}