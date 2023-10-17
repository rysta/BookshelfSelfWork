package com.example.bookshelfselfwork.data

import com.example.bookshelfselfwork.model.Book
import com.example.bookshelfselfwork.network.ApiClient

interface BookShelfRepository{
    suspend fun getBooks(): List<Book>
}

class NetworkBookShelfRepository(
    private val apiClient: ApiClient
) : BookShelfRepository{
    override suspend fun getBooks(): List<Book> = apiClient.getJazzBooks().items
}