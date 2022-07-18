package com.shobu95.crebitscompose.ui.screens.transactions.list.state

import com.shobu95.crebitscompose.domain.model.Transaction

data class TransactionListState(
    val transactions: List<Transaction> = emptyList(),
)

