package com.example.bookshelfselfwork.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bookshelfselfwork.R
import com.example.bookshelfselfwork.model.Book

@Composable
fun BookShelfScreen(
    bookShelfUiState: BookShelfUiState,
    modifier: Modifier
){
    when(bookShelfUiState){
        is BookShelfUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is BookShelfUiState.Success -> BookShelfGrid(bookShelfUiState.books, modifier)
        is BookShelfUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun BookShelfGrid(
    books: List<Book>,
    modifier: Modifier
){
    //todo LazyGrid и BooksGrid
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading"
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.ic_broken_image),
        contentDescription = "Error"
    )
}