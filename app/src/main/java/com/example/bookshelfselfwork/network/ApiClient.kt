package com.example.bookshelfselfwork.network

import com.example.bookshelfselfwork.model.BookShelf
import retrofit2.http.GET

interface ApiClient {
    @GET("?q=jazz+history")
    suspend fun getJazzBooks() : BookShelf
}