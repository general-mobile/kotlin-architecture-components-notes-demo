package com.generalmobile.app.gmnotes.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.generalmobile.app.gmnotes.R
import com.generalmobile.app.gmnotes.databinding.ItemNoteBinding
import com.generalmobile.app.gmnotes.db.entities.Note

class NoteAdapter(private var noteList: List<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    override fun getItemCount() = noteList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        val viewModel = NoteAdapterViewModel(noteList[position])
        binding.viewModel = viewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val postBinding = DataBindingUtil.inflate<ItemNoteBinding>(LayoutInflater.from(parent.context), R.layout.item_note, parent, false)

        return ViewHolder(postBinding)
    }

    fun addItems(notes: List<Note>) {
        noteList = notes
        notifyDataSetChanged()
    }


    class ViewHolder(var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)
}