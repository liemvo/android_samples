package com.vad.todovad.view.tasklist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vad.todovad.R
import com.vad.todovad.common.inflate
import com.vad.todovad.model.Task
import kotlinx.android.synthetic.main.task_item.view.*

class TaskListAdapter(private val tasks: MutableList<Task>) : RecyclerView.Adapter<TaskListAdapter.Companion.ViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.task_item))
    }
    
    override fun getItemCount() = tasks.size
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position])
    }
    
    fun updateTasks(tasks: List<Task>) {
        this.tasks.clear()
        this.tasks.addAll(tasks)
        notifyDataSetChanged()
    }
    
    companion object {
        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            fun bind(task: Task){
                itemView.title.text = task.title
            }
        }
    }
}