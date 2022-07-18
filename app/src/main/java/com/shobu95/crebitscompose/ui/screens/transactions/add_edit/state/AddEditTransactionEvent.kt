package com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state

sealed class AddEditTransactionEvent {
    data class EnteredAmount(val value: String) : AddEditTransactionEvent()
    data class EnteredTime(val value: String) : AddEditTransactionEvent()
    data class EnteredDate(val value: String) : AddEditTransactionEvent()
    data class EnteredDescription(val value: String) : AddEditTransactionEvent()
    data class ChangeType(val value: String) : AddEditTransactionEvent()
    object SaveTransaction : AddEditTransactionEvent()
}
