package com.vad.todovad.model.repository

import com.vad.todovad.model.Category
import com.vad.todovad.model.Task

interface RepositoryInterface {
    fun addCategory(category: Category)
    fun updateCategory(category: Category)
    fun getAllCategories(): List<Category>
    
    fun getAllTasks(): List<Task>
    fun addTask(task: Task)
    fun updateTask(task: Task)
    fun deleteTask(taskId: String)
    fun clearTasks(): Boolean
}