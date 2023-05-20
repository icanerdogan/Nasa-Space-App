package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import android.content.Context
import androidx.room.Room
import com.ibrahimcanerdogan.nasaspaceapp.data.database.AstronomyDao
import com.ibrahimcanerdogan.nasaspaceapp.data.database.EarthDao
import com.ibrahimcanerdogan.nasaspaceapp.data.database.MarsRoverDao
import com.ibrahimcanerdogan.nasaspaceapp.data.database.NasaDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) : NasaDatabase {
        return Room.databaseBuilder(context, NasaDatabase::class.java, "nasa")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideAstronomyDao(nasaDatabase: NasaDatabase): AstronomyDao {
        return nasaDatabase.astronomyDao()
    }

    @Singleton
    @Provides
    fun provideMarsRoverDao(nasaDatabase: NasaDatabase): MarsRoverDao {
        return nasaDatabase.marsRoverDao()
    }

    @Singleton
    @Provides
    fun provideEarthDao(nasaDatabase: NasaDatabase): EarthDao {
        return nasaDatabase.earthDao()
    }
}