package com.example.bookshelfselfwork.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelfselfwork.R
import com.example.bookshelfselfwork.model.Book

@Composable
fun BookShelfScreen(
    bookShelfUiState: BookShelfUiState,
    modifier: Modifier = Modifier
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
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize()
    ){
        items(items = books, key = {book -> book.id}){
            book -> BookCard(book, modifier)
        }
    }
}

@Composable
fun BookCard(book: Book, modifier: Modifier) {
    Card(
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.imageLinks.thumbnail.replace("http", "https"))
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "Jazz book",
            modifier = modifier.fillMaxWidth(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img)
        )
    }
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