package com.learning.porter_basic_database.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) :TodoDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            "todo_database"
        ).build()
    }


    @Provides
    fun provideTodoDao(db: TodoDatabase) : TodoDao {
        return db.taskItemTodo()
    }

    @Provides
    @Singleton
    fun provideRepository(todoDao: TodoDao):TodoRepository {
        return TodoRepository(todoDao)
    }
}