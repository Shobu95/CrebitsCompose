package com.shobu95.crebitscompose.ui.screens.transactions.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shobu95.crebitscompose.domain.use_cases.transaction.TransactionUseCases
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val transactionUseCases: TransactionUseCases,
) : ViewModel() {

    private val _state = mutableStateOf(TransactionListState())
    val state: State<TransactionListState> = _state


    init {
        getTransactions()
    }

    fun onEvent(event: TransactionEvent) {

        when (event) {

            is TransactionEvent.DeleteTransaction -> {
                viewModelScope.launch {
                    transactionUseCases.deleteTransaction(event.transaction)
                }
            }

            is TransactionEvent.EditTransaction -> {}
        }
    }

    private fun getTransactions() {
        viewModelScope.launch {
            transactionUseCases.getAllTransactions().collectLatest {
                _state.value = state.value.copy(
                    transactions = it
                )
            }
        }
    }


}