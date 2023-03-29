package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.astronomy

import com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.usecase.GetAstronomyUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.usecase.UpdateAstronomyUseCase
import com.ibrahimcanerdogan.nasaspaceapp.view.astronomy.AstronomyViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AstronomyModule {

    @AstronomyScope
    @Provides
    fun provideAstronomyViewModelFactory(
        getAstronomyUseCase: GetAstronomyUseCase,
        updateAstronomyUseCase: UpdateAstronomyUseCase
    ) : AstronomyViewModelFactory {
        return AstronomyViewModelFactory(
            getAstronomyUseCase,
            updateAstronomyUseCase
        )
    }
}