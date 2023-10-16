package com.example.bookshelfselfwork.ui.screen

import com.example.bookshelfselfwork.model.Book

sealed interface BookShelfUiState{
    data class Success(var books: List<Book>): BookShelfUiState

    object Error: BookShelfUiState

    object Loading: BookShelfUiState
}