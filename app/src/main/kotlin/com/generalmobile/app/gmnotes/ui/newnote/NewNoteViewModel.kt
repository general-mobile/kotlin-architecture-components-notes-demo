package com.generalmobile.app.gmnotes.ui.newnote

import android.view.View
import com.generalmobile.app.gmnotes.Application
import com.generalmobile.app.gmnotes.core.OnItemClickListener
import com.generalmobile.app.gmnotes.db.AppDatabase
import com.generalmobile.app.gmnotes.db.entities.Note
import java.util.*
import javax.inject.Inject

class NewNoteViewModel(val listener: OnItemClickListener, noteId: Long = -1) {
    @Inject
    lateinit var db: AppDatabase

    var note: Note = Note()

    init {
        Application.component?.inject(this)

        if (noteId > 0)
            getNote(noteId)
    }


    private fun getNote(noteId: Long) {
        Thread(Runnable { note = db.noteDao().getNote(noteId = noteId) }).start()
    }


    fun insert(view: View) {
        note.createDate = Date()
        Thread({
            db.noteDao().insertNote(note)

        }).start()

        listener.onItemClick(view)
    }
}