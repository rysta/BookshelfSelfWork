package com.example.bookshelfselfwork.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BookShelfScreen(
    bookShelfUiState: BookShelfUiState,
    modifier: Modifier
){
    /* TODO:
        when(uiState){
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AmphibiansUiState.Success -> AmphibiansGrid(uiState.amphibians, modifier)
        is AmphibiansUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
     */
}

@Composable
fun BookShelfGrid(
    books: List<Book>,
    modifier: Modifier
){
    //todo LazyGrid и BooksGrid
}