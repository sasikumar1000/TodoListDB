package com.learning.porter_basic_database.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodoViewModel(
    private val repository: TodoRepository
) : AndroidViewModel(Application()) {

    val allTodos: LiveData<List<Todo>> = repository.allTodos

    fun insert(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(todo)
    }

    fun update(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(todo)
    }

    fun delete(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(todo)
    }
}