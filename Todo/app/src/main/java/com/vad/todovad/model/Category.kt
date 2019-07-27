package com.vad.todovad.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(val id: String, val name: String, val isSelected: Boolean): Parcelable