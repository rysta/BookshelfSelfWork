package com.example.bookshelfselfwork.network

import com.example.bookshelfselfwork.model.Book
import retrofit2.http.GET

interface ApiClient {
    @GET("?q=jazz+history")
    suspend fun getJazzBooks() : List<Book>
}