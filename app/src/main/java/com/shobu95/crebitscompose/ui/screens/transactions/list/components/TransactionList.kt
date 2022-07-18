package com.shobu95.crebitscompose.ui.screens.transactions.list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shobu95.crebitscompose.ui.screens.transactions.list.TransactionViewModel
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionListState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun TransactionList(
    state: TransactionListState,
    viewModel: TransactionViewModel,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.transactions) { transaction ->
            TransactionItem(
                transaction = transaction,
                onDeleteClick = {
                    viewModel.onEvent(
                        TransactionEvent.DeleteTransaction(transaction)
                    )
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "Transaction Deleted"
                        )
                    }
                }
            ) {}
        }
    }

}