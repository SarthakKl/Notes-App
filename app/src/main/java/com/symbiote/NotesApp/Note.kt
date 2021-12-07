package com.symbiote.NotesApp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "note_table")
class Note(val description: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}