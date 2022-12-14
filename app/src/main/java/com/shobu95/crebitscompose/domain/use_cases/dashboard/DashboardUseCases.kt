package com.shobu95.crebitscompose.domain.use_cases.dashboard

import com.shobu95.crebitscompose.domain.use_cases.transaction.GetAllTransactionsUseCase

data class DashboardUseCases(
    val getAllTransactions: GetAllTransactionsUseCase,
    val getGraphData: GraphDataUseCase,
    val getCurrentMonthDeficit: GetCurrentMonthDeficitUseCase
)