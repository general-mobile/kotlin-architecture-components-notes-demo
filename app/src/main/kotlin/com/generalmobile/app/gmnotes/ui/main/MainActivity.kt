package com.generalmobile.app.gmnotes.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.generalmobile.app.gmnotes.R
import com.generalmobile.app.gmnotes.core.BaseActivity
import com.generalmobile.app.gmnotes.databinding.ActivityMainBinding
import com.generalmobile.app.gmnotes.db.entities.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var adapter: NoteAdapter = NoteAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {

        val noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)

        noteViewModel.getNotes().observe(this, Observer {
            if (it != null)
                fillRecycler(it)
        })

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = noteViewModel
        setActionBar(binding.toolbar)
        notesRecycler.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        notesRecycler.adapter = adapter
    }

    private fun fillRecycler(list: List<Note>) {
        adapter.addItems(list)
    }
}
