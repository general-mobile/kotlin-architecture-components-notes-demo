package com.generalmobile.app.gmnotes

import com.generalmobile.app.gmnotes.di.component.ApplicationComponent
import com.generalmobile.app.gmnotes.di.component.DaggerApplicationComponent
import com.generalmobile.app.gmnotes.di.module.ApplicationModule


class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()

        //di
        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()

    }

    companion object {

        var component: ApplicationComponent? = null
            private set
    }

}

