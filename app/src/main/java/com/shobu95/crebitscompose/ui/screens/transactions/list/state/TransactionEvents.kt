package com.shobu95.crebitscompose.ui.screens.transactions.list.state

import com.shobu95.crebitscompose.domain.model.Transaction

sealed class TransactionEvent {
    data class DeleteTransaction(val transaction: Transaction) : TransactionEvent()
    data class EditTransaction(val transaction: Transaction) : TransactionEvent()
}
