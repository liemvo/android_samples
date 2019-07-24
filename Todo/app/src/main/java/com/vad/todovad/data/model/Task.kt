package com.vad.todovad.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Task(
    val id: String,
    val title: String,
    val description: String,
    val dueDate: Date,
    val completedDate: Date,
    val startedDate: Date,
    val category: Category,
    val priority: Priorty,
    val isHidden: Boolean = false
) : Parcelable