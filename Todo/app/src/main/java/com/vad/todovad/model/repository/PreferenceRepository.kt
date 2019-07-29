package com.vad.todovad.model.repository

import com.vad.todovad.common.replace
import com.vad.todovad.model.Category
import com.vad.todovad.model.Task
import com.vad.todovad.model.TaskStatus
import com.vad.todovad.model.database.TodoPreferenceManager.getCategories
import com.vad.todovad.model.database.TodoPreferenceManager.getTasks
import com.vad.todovad.model.database.TodoPreferenceManager.saveCategories
import com.vad.todovad.model.database.TodoPreferenceManager.saveTasks

class PreferenceRepository : RepositoryInterface {
    private val categories = mutableListOf<Category>()
    private val tasks = mutableListOf<Task>()
    
    init {
        getCategories()?.let { categories.addAll(it) }
        getTasks()?.let { tasks.addAll(it) }
    }
    
    override fun addCategory(category: Category) {
        categories.add(category)
        saveCategories(categories)
    }
    
    override fun updateCategory(category: Category) {
        categories.replace(category) {
            it.id == category.id
        }
        saveCategories(categories)
    }
    
    override fun getAllCategories() = categories
    
    override fun getAllTasks() = tasks
    
    override fun addTask(task: Task) {
        tasks.add(task)
        saveTasks(tasks)
    }
    
    override fun updateTask(task: Task) {
        tasks.replace(task) {
            it.id == task.id
        }
        saveTasks(tasks)
    }
    
    override fun deleteTask(taskId: String) {
        val task = tasks.find { it.id == taskId }
        task?.let {
            tasks.remove(it)
            saveTasks(tasks)
        }
    }
    
    override fun clearTasks() {
        tasks.forEach {
            deleteTask(it.id)
        }
    }
    
    fun finishTask(task: Task) = updateTask(task.copy(status = TaskStatus.COMPLETE))
    fun getFavoriteTasks() = tasks.filter { it.isFavorite }.toList()
    fun getHiddenTasks() = tasks.filter { it.isHidden }.toList()
}