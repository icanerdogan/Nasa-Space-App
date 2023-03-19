package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyCacheDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasourceImpl.AstronomyCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideAstronomyCacheDataSource() : AstronomyCacheDataSource {
        return AstronomyCacheDataSourceImpl()
    }
}