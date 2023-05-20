package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection

import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.astronomy.AstronomySubComponent
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.earth.EarthSubComponent
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.marsrover.MarsRoverSubComponent

interface Injector {

    fun createAstronomySubComponent() : AstronomySubComponent

    fun createMarsRoverSubComponent() : MarsRoverSubComponent

    fun createEarthSubComponent() : EarthSubComponent

}