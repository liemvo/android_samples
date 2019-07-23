package com.vad.todovad.data.db

import com.vad.todovad.data.model.Task

interface iTaskDatabase {
    fun getAllTasks(): List<Task>
    fun addTask(task: Task)
    fun updateTask(task: Task)
    fun deleteTask(task: Task)
}