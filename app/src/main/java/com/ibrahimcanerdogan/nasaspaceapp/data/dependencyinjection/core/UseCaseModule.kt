package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.ibrahimcanerdogan.nasaspaceapp.domain.repository.AstronomyRepository
import com.ibrahimcanerdogan.nasaspaceapp.domain.usecase.GetAstronomyUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.usecase.UpdateAstronomyUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetAstronomyUseCase(movieRepository: AstronomyRepository) : GetAstronomyUseCase{
        return GetAstronomyUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: AstronomyRepository) : UpdateAstronomyUseCase {
        return UpdateAstronomyUseCase(movieRepository)
    }
}