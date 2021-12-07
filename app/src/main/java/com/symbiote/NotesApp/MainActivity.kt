package com.symbiote.NotesApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NoteRVListener {
    lateinit var viewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv=findViewById<RecyclerView>(R.id.main_rv)
        val adapter=NoteRVAdapter(this,this)
        rv.adapter=adapter
        rv.layoutManager=LinearLayoutManager(this)

        viewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory
            .getInstance(application))[NoteViewModel::class.java]
        viewModel.allNotes.observe(this, {
            adapter.updateList(it)
        })
    }

    override fun onClick(note: Note) {
        viewModel.deleteNote(note)
    }

    fun addNote(view:android.view.View) {
        val editText=findViewById<EditText>(R.id.main_editText)
        val note=Note(editText.text.toString())

        if(TextUtils.isEmpty(editText.text)){
            Toast.makeText(this, "Note can't be empty!", Toast.LENGTH_SHORT).show()
        }
        else{
            viewModel.insertNote(note)
        }
    }
}