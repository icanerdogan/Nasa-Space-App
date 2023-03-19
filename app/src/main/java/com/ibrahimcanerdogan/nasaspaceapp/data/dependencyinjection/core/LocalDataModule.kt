package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.ibrahimcanerdogan.nasaspaceapp.data.database.AstronomyDao
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasourceImpl.AstronomyLocalDataSourceImpl
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

}