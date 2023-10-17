package com.example.bookshelfselfwork.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelfselfwork.BookShelfApplication
import com.example.bookshelfselfwork.data.BookShelfRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class BookShelfViewModel(private val bookShelfRepository: BookShelfRepository) : ViewModel(){
    var uiState : BookShelfUiState by mutableStateOf(BookShelfUiState.Loading)

    init{
        getBooks()
    }

    fun getBooks(){
        viewModelScope.launch {
            uiState = BookShelfUiState.Loading
            uiState = try {
                var result = bookShelfRepository.getBooks()
                BookShelfUiState.Success(result)
            } catch (e: IOException) {
                BookShelfUiState.Error
            } catch (e: HttpException) {
                BookShelfUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookShelfApplication)
                val bookShelfRepository = application.container.bookShelfRepository
                BookShelfViewModel(bookShelfRepository = bookShelfRepository)
            }
        }
    }
}