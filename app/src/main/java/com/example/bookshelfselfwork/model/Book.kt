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
    val kind: String,
    val id: String,
    val imageLinks : ImageLinks = ImageLinks()
)

@Serializable
data class JazzBook(
    val id: String,
    val kind: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val imageLinks : ImageLinks
)

@Serializable
data class ImageLinks(
    val thumbnail: String = ""
)
