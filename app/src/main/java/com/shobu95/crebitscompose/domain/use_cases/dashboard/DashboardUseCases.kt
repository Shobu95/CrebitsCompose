package com.shobu95.crebitscompose.domain.use_cases.dashboard

import com.shobu95.crebitscompose.domain.use_cases.transaction.GetAllTransactionsUseCase

data class DashboardUseCases(
    val getGraphData: GraphDataUseCase,
    val getAllTransactions: GetAllTransactionsUseCase,
    val getCurrentMonthDeficit: CurrentMonthDeficitUseCase,
    val getCurrentMonthTransactions: CurrentMonthTransactionsUseCase
)