package com.learning.porter_basic_database.db

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.porter_basic_database.databinding.TaskItemBinding

class TodoAdapter(
    private val todoViewModel: TodoViewModel
) : RecyclerView.Adapter<TodoAdapter.TaskItemViewHolder>() {

    private var todos = emptyList<Todo>()

    class TaskItemViewHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val checkBox = binding.checkBoxCompleted
        val textViewTask = binding.textViewTask
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val view = TaskItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TaskItemViewHolder(binding = view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val currentTodo = todos[position]
        holder.textViewTask.text = currentTodo.task
        holder.checkBox.isChecked = currentTodo.isCompleted

        holder.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->

            val todo = currentTodo.copy(isCompleted = isChecked)
            todoViewModel.update(todo) }
        }
    internal fun setTodos(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }
}