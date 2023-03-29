package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.marsrover

import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.GetMarsRoverUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.UpdateMarsRoverUseCase
import com.ibrahimcanerdogan.nasaspaceapp.view.marsrover.MarsRoverViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MarsRoverModule {

    @MarsRoverScope
    @Provides
    fun provideMarsRoverViewModelFactory(
        getMarsRoverUseCase: GetMarsRoverUseCase,
        updateMarsRoverUseCase: UpdateMarsRoverUseCase
    ) : MarsRoverViewModelFactory {
        return MarsRoverViewModelFactory(
            getMarsRoverUseCase,
            updateMarsRoverUseCase
        )
    }
}