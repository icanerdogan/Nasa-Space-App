package com.ibrahimcanerdogan.nasaspaceapp.domain.astronomy.repository

import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

interface AstronomyRepository {
    suspend fun getAstronomyDataFromRepository() : List<Astronomy>?
    suspend fun updateAstronomyDataFromRepository() : List<Astronomy>?
}