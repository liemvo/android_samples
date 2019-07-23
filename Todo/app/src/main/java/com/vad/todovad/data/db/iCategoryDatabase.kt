package com.vad.todovad.data.db

import com.vad.todovad.data.model.Category

interface iCategoryDatabase {
    fun addCategory(category: Category)
    fun updateCategory(category: Category)
    fun getAllCategory(): List<Category>
}