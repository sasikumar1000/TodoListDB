package com.learning.porter_basic_database.db

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { provideDatabase(androidContext()) }
    single { provideTodoDao(get()) }
    single { provideRepository(get()) }
    viewModel { TodoViewModel(get()) }
}

fun provideDatabase(context: Context): TodoDatabase {
    return TodoDatabase.getDatabase(context)
}

fun provideTodoDao(db: TodoDatabase): TodoDao {
    return db.taskItemTodo()
}

fun provideRepository(todoDao: TodoDao): TodoRepository {
    return TodoRepository(todoDao)
}