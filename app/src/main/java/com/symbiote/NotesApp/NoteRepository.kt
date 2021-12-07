package com.symbiote.NotesApp

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao:NoteDao) {
    fun getAllNotes():LiveData<List<Note>> = noteDao.getAllNotes()

    fun insert(note:Note){
        noteDao.insert(note)
    }
    fun delete(note:Note){
        noteDao.delete(note)
    }
}