package com.generalmobile.app.gmnotes.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.generalmobile.app.gmnotes.db.entities.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM Note order by createDate desc")
    fun getNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM Note where id = :noteId")
    fun getNote(noteId: Long): Note

    @Insert(onConflict = REPLACE)
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("Select count(*) from Note")
    fun getCount(): Int

}