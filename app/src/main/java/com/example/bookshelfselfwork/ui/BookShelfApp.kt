package com.example.bookshelfselfwork.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelfselfwork.ui.screen.BookShelfScreen
import com.example.bookshelfselfwork.ui.screen.BookShelfViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { BookshelfScreenTopAppBar(scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
            val bookshelfViewModel: BookShelfViewModel = viewModel(factory = BookShelfViewModel.Factory)
            BookShelfScreen(bookShelfUiState = bookshelfViewModel.uiState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookshelfScreenTopAppBar(scrollBehavior: TopAppBarScrollBehavior) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "Bookshelf",
                style = MaterialTheme.typography.headlineMedium,
            )
        },
        modifier = Modifier
    )
}