package com.vad.todovad.presenter

import com.vad.todovad.app.Injection.provideRepository
import com.vad.todovad.common.generateUUID
import com.vad.todovad.model.Task
import com.vad.todovad.model.TaskStatus
import com.vad.todovad.model.repository.RepositoryInterface

class TaskPresenter(private val repository: RepositoryInterface = provideRepository()): BasePresenter<TaskContract.View>(), TaskContract.Presenter {
    
    private val view
        get() = getView()
    
    private var task: Task = Task(id = "", title = "", description = "", status = TaskStatus.OPEN)
    
    override fun updateTitle(title: String) {
        task = task.copy(title = title)
    }
    
    override fun updateDescription(description: String) {
        task = task.copy(description = description)
    }
    
    override fun saveTask() {
        task = task.copy(id = generateUUID())
        if (canSave()) {
            repository.addTask(task)
            view?.showTaskSaved()
        } else {
            view?.showTaskError()
        }
    }
    
    private fun canSave() = task.title.isNotEmpty() && task.description.isNotEmpty()
}