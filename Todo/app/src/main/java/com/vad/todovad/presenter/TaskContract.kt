package com.vad.todovad.presenter

interface TaskContract {
    interface Presenter {
        fun updateTitle(title: String)
        fun updateDescription(description: String)
        fun saveTask()
    }
    
    interface View {
        fun showTaskSaved()
        fun showTaskError()
    }
}