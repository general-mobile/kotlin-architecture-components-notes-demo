package com.generalmobile.app.gmnotes

import com.generalmobile.app.gmnotes.di.component.DaggerApplicationComponent
import com.generalmobile.app.gmnotes.di.module.ApplicationModule


class Application : android.app.Application() {

    val component by lazy { DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build() }

    override fun onCreate() {
        super.onCreate()
    }
}

