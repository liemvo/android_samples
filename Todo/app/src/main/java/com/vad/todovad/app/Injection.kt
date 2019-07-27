package com.vad.todovad.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vad.todovad.model.repository.PreferenceRepository
import com.vad.todovad.model.repository.RepositoryInterface

object Injection {
    fun provideGson(): Gson = GsonBuilder().setPrettyPrinting().create()
    
    fun provideRepository(): RepositoryInterface = PreferenceRepository()
}