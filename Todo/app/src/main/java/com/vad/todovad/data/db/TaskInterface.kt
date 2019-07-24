package com.vad.todovad.data.db

import com.vad.todovad.data.model.Task

interface TaskInterface {
    fun getAllTasks(): List<Task>
    fun addTask(task: Task)
    fun updateTask(task: Task)
    fun deleteTask(taskId: String)
}