package com.example.bookshelfselfwork.network

import com.example.bookshelfselfwork.model.BookShelf
import com.example.bookshelfselfwork.model.JazzBook
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("volumes?q=jazz+history")
    suspend fun getJazzBooks(): BookShelf

    @GET("volumes/{id}")
    suspend fun getBook(
        @Path("id") id: String
    ): JazzBook
}