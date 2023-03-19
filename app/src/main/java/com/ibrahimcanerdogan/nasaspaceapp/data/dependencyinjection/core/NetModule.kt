package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.core

import com.google.gson.GsonBuilder
import com.ibrahimcanerdogan.nasaspaceapp.data.api.APIService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(
    private val baseUrl : String
) {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) : APIService {
        return retrofit.create(APIService::class.java)
    }
}