package com.vad.todovad.app

import android.app.Application
import android.content.Context

class TodoApplication : Application() {
    companion object {
        private lateinit var instance: TodoApplication
        val applicationContext: Context
            get() = instance.applicationContext
    }
    
    override fun onCreate() {
        instance = this
        super.onCreate()
    }
    
}