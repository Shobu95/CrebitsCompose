package com.shobu95.crebitscompose.ui.screens.home.transactions.state

import com.shobu95.crebitscompose.domain.model.TransactionData

sealed class TransactionEvent {
    data class DeleteTransaction(val transaction: TransactionData) : TransactionEvent()
    data class EditTransaction(val transaction: TransactionData) : TransactionEvent()
}
