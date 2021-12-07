package com.symbiote.NotesApp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(private val context: Context,private val listener:NoteRVListener):RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {
    private val allNotes=ArrayList<Note>()
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val desc=view.findViewById<TextView>(R.id.item_description)
        val delete=view.findViewById<ImageView>(R.id.item_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder=ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_rv_item,parent,false))
        viewHolder.delete.setOnClickListener {
            listener.onClick(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note=allNotes[position]
        holder.desc.text=note.description
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList:List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return allNotes.size
    }
}
interface NoteRVListener{
    fun onClick(note:Note)
}