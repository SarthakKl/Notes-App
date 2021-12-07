package com.symbiote.NotesApp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict=OnConflictStrategy.IGNORE, entity = Note::class)
    fun insert(note:Note)

    @Delete(entity = Note::class)
    fun delete(note:Note)

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun getAllNotes():LiveData<List<Note>>
}