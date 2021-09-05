package com.ianschoenrock.wfhcompanion.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
class ToDo(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val Content: String
)