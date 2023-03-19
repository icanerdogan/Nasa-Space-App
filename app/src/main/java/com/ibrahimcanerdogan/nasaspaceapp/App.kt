package com.ibrahimcanerdogan.nasaspaceapp

import android.app.Application
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.Injector
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.astronomy.AstronomySubComponent
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core.*

class App : Application(), Injector {

    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.nasa.gov/planetary/"))
            .remoteDataModule(RemoteDataModule("tfzaFa2oOmd1L3CZfyJyylMQZEuSC65Ol9msftrZ"))
            .build()

    }

    override fun createAstronomySubComponent(): AstronomySubComponent {
        return appComponent.astronomySubComponent().create()
    }
}