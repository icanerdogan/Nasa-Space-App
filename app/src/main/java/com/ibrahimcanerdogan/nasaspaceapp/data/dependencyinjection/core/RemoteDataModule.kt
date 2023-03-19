package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.ibrahimcanerdogan.nasaspaceapp.data.api.APIService
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasource.AstronomyRemoteDataSource
import com.ibrahimcanerdogan.nasaspaceapp.data.repository.astronomy.datasourceImpl.AstronomyRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(
    private val apiKey : String
) {

    @Singleton
    @Provides
    fun provideAstronomyRemoteDataSource(apiService: APIService) : AstronomyRemoteDataSource {
        return AstronomyRemoteDataSourceImpl(apiService, apiKey)
    }
}