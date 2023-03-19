package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.AstronomyRepositoryImpl
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyCacheDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyLocalDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyRemoteDataSource
import com.ibrahimcanerdogan.nasaspaceapp.domain.repository.AstronomyRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAstronomyRepository(
        astronomyRemoteDataSource: AstronomyRemoteDataSource,
        astronomyLocalDataSource: AstronomyLocalDataSource,
        astronomyCacheDataSource: AstronomyCacheDataSource
    ) : AstronomyRepository {
        return AstronomyRepositoryImpl(
            astronomyRemoteDataSource,
            astronomyLocalDataSource,
            astronomyCacheDataSource
        )
    }
}