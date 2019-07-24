package com.vad.todovad.data.db

import com.vad.todovad.data.model.Category

interface CategoryInterface {
    fun addCategory(category: Category)
    fun updateCategory(category: Category)
    fun getAllCategories(): List<Category>
}