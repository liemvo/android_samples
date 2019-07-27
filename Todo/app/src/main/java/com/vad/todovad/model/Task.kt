package com.vad.todovad.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Task(
    val id: String = "",
    val title: String,
    val description: String,
    val dueDate: Date? = null,
    val completedDate: Date? = null,
    val startedDate: Date? = null,
    val category: Category? = null,
    val priority: Priorty? = null,
    val isHidden: Boolean = false,
    val isFavorite: Boolean = false,
    val status: TaskStatus
) : Parcelable
