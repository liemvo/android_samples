package com.vad.todovad.presenter

import androidx.lifecycle.LiveData
import com.vad.todovad.model.Task

interface AllTasksContract {
    interface Presenter {
        fun getAllTasks(): LiveData<List<Task>>
        fun clearAllTasks(): Boolean
    }
    
    interface View {
        fun showTasksCleared()
    }
}