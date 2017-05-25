package com.generalmobile.app.gmnotes.ui.main

import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.view.View
import com.generalmobile.app.gmnotes.db.entities.Note
import com.generalmobile.app.gmnotes.ui.newnote.NewNoteActivity
import java.text.SimpleDateFormat
import java.util.*

class NoteAdapterViewModel(var note: Note) : ViewModel() {

    var currentDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    var pastDateFormat = SimpleDateFormat("dd:MM:yyyy", Locale.getDefault())

    fun getNoteTitle() = note.title

    fun getNoteText() = note.note

    fun getNoteDate(): String {
        val today = Date()
        if (note.createDate.day == today.day && note.createDate.month == today.month && note.createDate.year == note.createDate.year)
            return currentDateFormat.format(note.createDate)
        else
            return pastDateFormat.format(note.createDate)
    }

    fun onClick(view: View) {
        var intent = Intent(view.context, NewNoteActivity::class.java)
        intent.putExtra("noteId", note.id)
        view.context.startActivity(intent)
    }

}