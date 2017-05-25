package com.generalmobile.app.gmnotes.di.component

import android.content.Context
import android.content.SharedPreferences
import com.generalmobile.app.gmnotes.Application
import com.generalmobile.app.gmnotes.db.AppDatabase
import com.generalmobile.app.gmnotes.di.module.ApplicationModule
import com.generalmobile.app.gmnotes.di.module.DatabaseModule
import com.generalmobile.app.gmnotes.ui.main.NoteViewModel
import com.generalmobile.app.gmnotes.ui.newnote.NewNoteViewModel


import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DatabaseModule::class))
interface ApplicationComponent {
    fun app(): Application

    fun context(): Context

    fun preferences(): SharedPreferences

    fun database(): AppDatabase

    fun inject(noteViewModel: NoteViewModel)

    fun inject(newNoteViewModel: NewNoteViewModel)
}
