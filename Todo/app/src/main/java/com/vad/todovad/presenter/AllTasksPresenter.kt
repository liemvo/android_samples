package com.vad.todovad.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vad.todovad.app.Injection.provideRepository
import com.vad.todovad.model.Task
import com.vad.todovad.model.repository.RepositoryInterface

class AllTasksPresenter(private val repository: RepositoryInterface = provideRepository()): BasePresenter<AllTasksContract.View>(), AllTasksContract.Presenter {
    override fun getAllTasks(): LiveData<List<Task>> {
        val liveData = MutableLiveData<List<Task>>()
        liveData.value = repository.getAllTasks()
        return liveData
    }
    
    override fun clearAllTasks() = repository.clearTasks()
    
}