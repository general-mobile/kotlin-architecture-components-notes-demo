package com.generalmobile.app.gmnotes.ui.newnote

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.generalmobile.app.gmnotes.R
import com.generalmobile.app.gmnotes.core.BaseActivity
import com.generalmobile.app.gmnotes.databinding.ActivityNewNoteBinding

class NewNoteActivity : BaseActivity(), (View) -> Unit {

    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_note)
        var noteId = -1L
        if (intent != null && intent.extras != null)
            noteId = intent.extras.getLong("noteId", -1)
        binding.model = NewNoteViewModel(this, noteId)

    }

    override fun invoke(view: View) {
        Toast.makeText(this, getString(R.string.note_success), Toast.LENGTH_SHORT).show()
        finish()
    }
}