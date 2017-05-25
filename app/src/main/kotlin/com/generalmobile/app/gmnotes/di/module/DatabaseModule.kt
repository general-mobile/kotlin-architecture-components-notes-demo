package com.generalmobile.app.gmnotes.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.generalmobile.app.gmnotes.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context,
                AppDatabase::class.java, "note-db").build()
    }

}