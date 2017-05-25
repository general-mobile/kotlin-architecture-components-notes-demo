package com.generalmobile.app.gmnotes.db.converters

import android.arch.persistence.room.TypeConverter
import java.util.*


class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    fun dateToTimestamp(date: Date?): Long {
        return date?.time ?: 0L
    }
}