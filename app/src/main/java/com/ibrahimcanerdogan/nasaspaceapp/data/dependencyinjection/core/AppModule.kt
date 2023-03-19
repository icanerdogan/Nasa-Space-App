package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import android.content.Context
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.astronomy.AstronomySubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [AstronomySubComponent::class])
class AppModule(
    private val context: Context
) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context {
        return context.applicationContext
    }
}