package com.generalmobile.app.gmnotes.ui.main

import android.arch.lifecycle.AndroidViewModel
import android.content.Intent
import com.generalmobile.app.gmnotes.Application
import com.generalmobile.app.gmnotes.db.entities.Note
import com.generalmobile.app.gmnotes.ui.newnote.NewNoteActivity
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapterViewModel(var application: Application) : AndroidViewModel(application) {

    var currentDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    var pastDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    lateinit var note: Note

    fun getNoteTitle() = note.title

    fun getNoteText() = note.note

    fun getNoteDate(): String {
        val today = Date()
        if (note.createDate.day == today.day && note.createDate.month == today.month && note.createDate.year == note.createDate.year)
            return currentDateFormat.format(note.createDate)
        else
            return pastDateFormat.format(note.createDate)
    }

    fun onClick() {
        val intent = Intent(application, NewNoteActivity::class.java)
        intent.putExtra("noteId", note.id)
        application.startActivity(intent)
    }

}