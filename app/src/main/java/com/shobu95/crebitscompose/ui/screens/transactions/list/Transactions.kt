package com.shobu95.crebitscompose.ui.screens.transactions.list

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionListState
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar
import com.shobu95.crebitscompose.ui.theme.ThemeBackground
import com.shobu95.crebitscompose.ui.theme.ThemeBlack
import com.shobu95.crebitscompose.ui.theme.ThemeWhite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Preview
@Composable
fun TransactionsPreview() {
    TransactionsScreen(
        HomeScreenItem.Transactions.title,
        hiltViewModel(),
        {}
    )
}


@Composable
fun TransactionsScreen(
    @StringRes title: Int,
    viewModel: TransactionViewModel = hiltViewModel(),
    onAddClick: () -> Unit,
) {

    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = ThemeBackground,
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                false
            ) {}
        },
        floatingActionButton = { AddTransactionFab(onAddClick) },
        floatingActionButtonPosition = FabPosition.End
    ) {
        TransactionBody(
            state = state,
            viewModel = viewModel,
            scope = scope,
            scaffoldState = scaffoldState
        )
    }
}

@Composable
fun TransactionBody(
    state: TransactionListState,
    viewModel: TransactionViewModel,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
) {
    Column(
        modifier = Modifier.padding(14.dp)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.transactions) { transaction ->
                TransactionItem(
                    transactionData = transaction,
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
}


@Composable
fun AddTransactionFab(onAddClick: () -> Unit) {
    FloatingActionButton(
        onClick = onAddClick,
        backgroundColor = ThemeBlack,
        contentColor = ThemeWhite
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add Transaction")
    }
}

