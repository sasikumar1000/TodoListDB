package com.learning.porter_basic_database

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learning.porter_basic_database.databinding.ActivityMainBinding
import com.learning.porter_basic_database.db.Todo
import com.learning.porter_basic_database.db.TodoAdapter
import com.learning.porter_basic_database.db.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val todoViewModel: TodoViewModel by viewModel()
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        todoAdapter = TodoAdapter(todoViewModel)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = todoAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        todoViewModel.allTodos.observe(this, Observer { todos ->
            todos?.let { todoAdapter.setTodos(it) }
        })
        val buttonAdd = binding.buttonAdd
        val editTextTask = binding.editTextTask

        buttonAdd.setOnClickListener {
            val task = editTextTask.text.toString()
            if (task.isNotEmpty()) {
                val todo = Todo(task = task, isCompleted = false)
                todoViewModel.insert(todo)
                editTextTask.text.clear()
            }
        }
    }



    }