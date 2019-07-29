package com.vad.todovad.view.tasklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.vad.todovad.R
import com.vad.todovad.common.inflate
import com.vad.todovad.presenter.AllTasksContract
import com.vad.todovad.presenter.AllTasksPresenter

class TaskListFragment: Fragment(), AllTasksContract.View {
    companion object {
        fun newInstance(): TaskListFragment {
            return TaskListFragment()
        }
    }
    
    private val presenter = AllTasksPresenter()
    private val adapter = TaskListAdapter(mutableListOf())
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.fragment_task_list)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.getAllTasks().observe(viewLifecycleOwner, Observer {
            adapter.updateTasks(it)
        })
    }
    
    override fun showTasksCleared() {
    
    }
}