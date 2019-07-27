package com.vad.todovad.model.database

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.reflect.TypeToken
import com.vad.todovad.app.Injection.provideGson
import com.vad.todovad.app.TodoApplication
import com.vad.todovad.model.Category
import com.vad.todovad.model.Task

object TodoPreferenceManager {
    private const val KEY_TASKS = "KEY_TASKS"
    private const val KEY_CATEGORIES = "KEY_CATEGORIES"
    
    private fun sharedPreferences() =
        PreferenceManager.getDefaultSharedPreferences(TodoApplication.applicationContext)
    
    fun saveTasks(tasks: List<Task>) {
        sharedPreferences().edit().apply {
            putList(KEY_TASKS, tasks)
        }.apply()
    }
    
    fun getTasks(): List<Task>? {
        return sharedPreferences()
            .getString(KEY_TASKS, null)?.run {
            provideGson().fromJson(this, object : TypeToken<List<Task>>() {}.type)
        }
    }
    
    fun saveCategories(tasks: List<Category>) {
        sharedPreferences().edit().apply {
            putList(KEY_CATEGORIES, tasks)
        }.apply()
    }
    
    fun getCategories(): List<Category>? {
        return sharedPreferences()
            .getString(KEY_CATEGORIES, null)?.run {
            provideGson().fromJson(this, object : TypeToken<List<Category>>() {}.type)
        }
    }
}

private fun <T> SharedPreferences.Editor.putList(key: String, list: List<T>) {
    putString(key, provideGson().toJson(list))
}
