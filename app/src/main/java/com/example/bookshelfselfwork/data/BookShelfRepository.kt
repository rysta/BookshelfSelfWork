package com.example.bookshelfselfwork.data

import com.example.bookshelfselfwork.model.Book
import com.example.bookshelfselfwork.network.ApiClient

interface BookShelfRepository{
    suspend fun getBooks(): List<Book>
}

class NetworkBookShelfRepository(
    private val apiClient: ApiClient
) : BookShelfRepository{
    override suspend fun getBooks(): List<Book>{
        val bookShelf = apiClient.getJazzBooks();
        var books = mutableListOf<Book>()

        bookShelf.items.forEach{
            item ->
                var book = apiClient.getBook(item.id)
                books.add(Book( book.kind, book.id, book.volumeInfo.imageLinks  ))
        }
        return books
    }
}