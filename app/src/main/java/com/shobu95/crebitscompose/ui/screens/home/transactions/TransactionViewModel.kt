package com.shobu95.crebitscompose.ui.screens.home.transactions

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.shobu95.crebitscompose.ui.screens.home.transactions.state.AddTransactionState

class TransactionViewModel : ViewModel() {

    var uiState by mutableStateOf(AddTransactionState())
        private set


}