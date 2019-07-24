package com.vad.todovad.app

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object Injection {
    fun provideGson(): Gson = GsonBuilder().setPrettyPrinting().create()
}