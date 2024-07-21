package com.learning.porter_basic_database.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface TodoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun allTodos() : LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(taskItem: Todo)

    @Update
    fun update(taskItem: Todo)

    @Delete
    fun delete(taskItem: Todo)
}

