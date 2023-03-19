package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection

import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.astronomy.AstronomySubComponent

interface Injector {

    fun createAstronomySubComponent() : AstronomySubComponent

}