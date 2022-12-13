package com.shobu95.crebitscompose.domain.use_cases.dashboard

import com.shobu95.crebitscompose.domain.use_cases.transaction.GetAllTransactionsUseCase

data class DashboardUseCases(
    val getAllTransactionsUseCase: GetAllTransactionsUseCase,
    val getTransactionGraphDataUseCase: TransactionGraphDataUseCase
)