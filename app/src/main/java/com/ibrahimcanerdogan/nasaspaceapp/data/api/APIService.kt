package com.ibrahimcanerdogan.nasaspaceapp.data.api

import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("apod?count=20")
    suspend fun getAstronomersFromAPI(@Query("api_key") apiKey : String) : Response<List<Astronomy>>
}