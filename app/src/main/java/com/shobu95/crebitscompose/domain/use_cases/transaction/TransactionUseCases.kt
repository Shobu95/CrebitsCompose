package com.shobu95.crebitscompose.domain.use_cases.transaction

data class TransactionUseCases(
    val getAllTransactions: GetAllTransactionsUseCase,
    val addTransaction: AddTransactionUseCase,
    val deleteTransaction: DeleteTransactionUseCase,
    val getTransactionById: GetTransactionByIdUseCase,
)
