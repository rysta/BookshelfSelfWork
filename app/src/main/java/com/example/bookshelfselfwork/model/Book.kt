package com.example.bookshelfselfwork.model

import kotlinx.serialization.Serializable

@Serializable
data class BookShelf(
    val kind: String,
    val totalItems: Int,
    val items: List<Book>
)

@Serializable
data class Book(
    val id: Int,
    val imageLinks : ImageLinks
)

@Serializable
data class ImageLinks(
    val thumbnail: String
)
