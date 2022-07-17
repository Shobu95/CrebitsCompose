package com.shobu95.crebitscompose.ui.screens.home.transactions.state

import com.shobu95.crebitscompose.domain.model.TransactionData


data class TransactionListState(
    val transactions: List<TransactionData> = emptyList(),
)

data class AddTransactionState(
    val transaction: TransactionData = TransactionData(),
)
