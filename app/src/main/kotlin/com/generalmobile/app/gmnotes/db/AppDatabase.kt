package com.generalmobile.app.gmnotes.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.generalmobile.app.gmnotes.db.dao.NoteDao
import com.generalmobile.app.gmnotes.db.entities.Note

@Database(entities = arrayOf(Note::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}