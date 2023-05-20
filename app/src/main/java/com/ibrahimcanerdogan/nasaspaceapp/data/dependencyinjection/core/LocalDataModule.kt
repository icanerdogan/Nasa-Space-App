package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.ibrahimcanerdogan.nasaspaceapp.data.database.AstronomyDao
import com.ibrahimcanerdogan.nasaspaceapp.data.database.EarthDao
import com.ibrahimcanerdogan.nasaspaceapp.data.database.MarsRoverDao
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasourceImpl.AstronomyLocalDataSourceImpl
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth.datasource.EarthLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.earth.datasourceImpl.EarthLocalDataSourceImpl
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasource.MarsRoverLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.marsrover.datasourceImpl.MarsRoverLocalDataSourceImpl
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRover
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideAstronomyLocalDataSource(astronomyDao: AstronomyDao) : AstronomyLocalDataSource {
        return AstronomyLocalDataSourceImpl(astronomyDao)
    }

    @Singleton
    @Provides
    fun provideMarsRoverLocalDataSource(marsRoverDao: MarsRoverDao) : MarsRoverLocalDataSource {
        return MarsRoverLocalDataSourceImpl(marsRoverDao)
    }

    @Singleton
    @Provides
    fun provideEarthLocalDataSource(earthDao: EarthDao) : EarthLocalDataSource {
        return EarthLocalDataSourceImpl(earthDao)
    }
}