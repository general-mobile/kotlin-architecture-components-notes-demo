package com.generalmobile.app.gmnotes.ui.newnote

import android.arch.lifecycle.AndroidViewModel
import com.generalmobile.app.gmnotes.Application
import com.generalmobile.app.gmnotes.db.AppDatabase
import com.generalmobile.app.gmnotes.db.entities.Note
import java.util.*
import javax.inject.Inject

class NewNoteViewModel(val listener: () -> Unit, noteId: Long = -1, var application: Application) : AndroidViewModel(application) {
    @Inject
    lateinit var db: AppDatabase

    var note: Note = Note()

    init {
        application.component.inject(this)

        if (noteId > 0)
            getNote(noteId)
    }

    private fun getNote(noteId: Long) {
        Thread(Runnable { note = db.noteDao().getNote(noteId = noteId) }).start()
    }

    fun insert() {

        note.createDate = Date()
        Thread({
            db.noteDao().insertNote(note)

        }).start()
        listener.invoke()
    }
}