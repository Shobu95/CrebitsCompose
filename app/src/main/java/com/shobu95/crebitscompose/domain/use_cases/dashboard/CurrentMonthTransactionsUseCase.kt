package com.shobu95.crebitscompose.domain.use_cases.dashboard

import com.shobu95.crebitscompose.domain.model.Transaction
import com.shobu95.crebitscompose.domain.utils.DateTimeHelpers

class CurrentMonthTransactionsUseCase {

    operator fun invoke(transactions: List<Transaction>): List<Transaction> {
        val currentMonth = DateTimeHelpers.getCurrentMonth()

        val currentMonthTransactions = transactions.filter { transaction ->
            val monthOfTransaction = transaction.date?.split('/')!![1]
            monthOfTransaction.toInt() == currentMonth
        }

        return currentMonthTransactions
    }
}