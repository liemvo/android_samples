package com.vad.todovad.data.repository

import com.vad.todovad.app.replace
import com.vad.todovad.data.db.CategoryInterface
import com.vad.todovad.data.db.TaskInterface
import com.vad.todovad.data.db.TodoPreferenceManager.getCategories
import com.vad.todovad.data.db.TodoPreferenceManager.getTasks
import com.vad.todovad.data.db.TodoPreferenceManager.saveCategories
import com.vad.todovad.data.db.TodoPreferenceManager.saveTasks
import com.vad.todovad.data.model.Category
import com.vad.todovad.data.model.Task
import com.vad.todovad.data.model.TaskStatus

class PreferenceRepository : CategoryInterface, TaskInterface {
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
    
    fun finishTask(task: Task) = updateTask(task.copy(status = TaskStatus.COMPLETE))
    fun getFavoriteTasks() = tasks.filter { it.isFavorite }.toList()
    fun getHiddenTasks() = tasks.filter { it.isHidden }.toList()
}