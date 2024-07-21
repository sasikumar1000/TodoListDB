package com.learning.porter_basic_database.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "task") val task: String,
    @ColumnInfo(name = "isCompleted") val isCompleted: Boolean
)
