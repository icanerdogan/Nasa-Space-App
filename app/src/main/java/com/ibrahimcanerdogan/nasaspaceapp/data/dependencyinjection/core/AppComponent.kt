package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.astronomy.AstronomySubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun astronomySubComponent() : AstronomySubComponent.Factory
}