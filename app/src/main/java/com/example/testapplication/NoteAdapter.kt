package com.example.testapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter(private val onItemClickListener : (Note) -> Unit) :
    ListAdapter<Note, NoteAdapter.NoteHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        var view  = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(view)
    }

    fun getNoteAt(position: Int) = getItem(position)

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        var note = getItem(position)
        holder.setData(note)
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClickListener(getItem(adapterPosition))
            }
        }

        fun setData(note: Note?){
            itemView.text_view_title.text = note?.title
            itemView.text_view_description.text = note?.description
            itemView.text_view_priority.text = note?.priority.toString()
        }
    }
}

private val diffCallBack = object : DiffUtil.ItemCallback<Note>(){
    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note) =
        oldItem.title == newItem.title
                && oldItem.description == oldItem.description
                && oldItem.priority == newItem.priority

}