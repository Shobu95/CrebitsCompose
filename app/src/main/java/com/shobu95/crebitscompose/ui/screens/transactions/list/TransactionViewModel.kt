package com.shobu95.crebitscompose.ui.screens.transactions.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shobu95.crebitscompose.domain.use_cases.transaction.TransactionUseCases
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val transactionUseCases: TransactionUseCases,
) : ViewModel() {


    private val _state = mutableStateOf(TransactionListState())
    val state: State<TransactionListState> = _state

    private var getTransactionsJob: Job? = null

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

        getTransactionsJob?.cancel()
        getTransactionsJob = transactionUseCases.getAllTransactions()
            .onEach { transactions ->
                _state.value = state.value.copy(
                    transactions = transactions
                )
            }.launchIn(viewModelScope)
    }


}