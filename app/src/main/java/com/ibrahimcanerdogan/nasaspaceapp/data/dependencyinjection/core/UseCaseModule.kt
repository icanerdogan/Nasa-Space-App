package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.repository.AstronomyRepository
import com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.usecase.GetAstronomyUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.usecase.UpdateAstronomyUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.earth.repository.EarthRepository
import com.ibrahimcanerdogan.nasaspaceapp.domain.earth.usecase.GetEarthUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.repository.MarsRoverRepository
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.GetMarsRoverUseCase
import com.ibrahimcanerdogan.nasaspaceapp.domain.marsrover.usecase.UpdateMarsRoverUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetAstronomyUseCase(movieRepository: AstronomyRepository) : GetAstronomyUseCase {
        return GetAstronomyUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: AstronomyRepository) : UpdateAstronomyUseCase {
        return UpdateAstronomyUseCase(movieRepository)
    }

    @Provides
    fun provideGetMarsRoverUseCase(marsRoverRepository: MarsRoverRepository) : GetMarsRoverUseCase {
        return GetMarsRoverUseCase(marsRoverRepository)
    }

    @Provides
    fun provideUpdateMarsRoverUseCase(marsRoverRepository: MarsRoverRepository) : UpdateMarsRoverUseCase {
        return UpdateMarsRoverUseCase(marsRoverRepository)
    }

    @Provides
    fun provideGetEarthUseCase(earthRepository: EarthRepository) : GetEarthUseCase {
        return GetEarthUseCase(earthRepository)
    }
}