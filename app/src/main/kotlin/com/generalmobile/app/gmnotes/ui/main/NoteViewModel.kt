package com.generalmobile.app.gmnotes.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Intent
import com.generalmobile.app.gmnotes.db.AppDatabase
import com.generalmobile.app.gmnotes.db.entities.Note
import com.generalmobile.app.gmnotes.ui.newnote.NewNoteActivity
import javax.inject.Inject

class NoteViewModel(val app: Application) : AndroidViewModel(app) {
    private var notes: LiveData<List<Note>>? = null

    @Inject
    lateinit var db: AppDatabase

    init {
        if (app is com.generalmobile.app.gmnotes.Application)
            app.component.inject(this)
    }

    fun getNotes(): LiveData<List<Note>> {
        if (notes == null) {
            notes = MutableLiveData<List<Note>>()
            loadNotes()
        }

        return notes!!;
    }

    private fun loadNotes() {
        notes = db.noteDao().getNotes()
    }

    fun fabClick() {
        app.startActivity(Intent(app, NewNoteActivity::class.java))
    }

}