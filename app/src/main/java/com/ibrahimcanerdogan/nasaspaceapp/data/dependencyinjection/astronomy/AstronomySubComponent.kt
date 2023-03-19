package com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.astronomy

import com.ibrahimcanerdogan.nasaspaceapp.view.astronomy.AstronomyFragment
import dagger.Subcomponent

@AstronomyScope
@Subcomponent(modules = [AstronomyModule::class])
interface AstronomySubComponent {

    fun inject(astronomyFragment: AstronomyFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : AstronomySubComponent
    }

}