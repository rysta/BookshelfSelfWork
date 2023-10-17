package com.example.bookshelfselfwork

import android.app.Application
import com.example.bookshelfselfwork.data.AppContainer
import com.example.bookshelfselfwork.data.DefaultContainer

class BookShelfApplication : Application() {
    lateinit var container : AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer()
    }
}