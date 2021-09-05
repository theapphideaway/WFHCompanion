package com.ianschoenrock.wfhcompanion.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val content: String
)