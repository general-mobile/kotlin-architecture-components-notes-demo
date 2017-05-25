package com.generalmobile.app.gmnotes.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.view.View
import com.generalmobile.app.gmnotes.Application
import com.generalmobile.app.gmnotes.db.AppDatabase
import com.generalmobile.app.gmnotes.db.entities.Note
import com.generalmobile.app.gmnotes.ui.newnote.NewNoteActivity
import javax.inject.Inject

class NoteViewModel : ViewModel() {
    private var notes: LiveData<List<Note>>? = null

    @Inject
    lateinit var db: AppDatabase
    @Inject
    lateinit var context: Context

    init {
        Application.component?.inject(this)
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

    fun fabClick(view: View) {
        context.startActivity(Intent(context, NewNoteActivity::class.java))
    }

}