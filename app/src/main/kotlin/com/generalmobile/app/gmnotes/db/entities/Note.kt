package com.generalmobile.app.gmnotes.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.generalmobile.app.gmnotes.db.converters.DateConverter
import java.util.*


@Entity()
@TypeConverters(DateConverter::class)
class Note {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
    var title: String = ""
    var note: String = ""
    var createDate: Date = Date()
}