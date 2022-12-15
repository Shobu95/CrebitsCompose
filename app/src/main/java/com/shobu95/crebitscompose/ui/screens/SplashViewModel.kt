package com.shobu95.crebitscompose.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shobu95.crebitscompose.data.datastore.CrebitsDatastore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val crebitsDatastore: CrebitsDatastore
) : ViewModel() {

    var isDarkTheme by mutableStateOf(true)
        private set

    init {
        checkForDarkTheme()
    }

    private fun checkForDarkTheme() {
        try {
            viewModelScope.launch {
                crebitsDatastore.getStringData("dark_mode").collectLatest {
                    if (it) {
                        isDarkTheme = it
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}