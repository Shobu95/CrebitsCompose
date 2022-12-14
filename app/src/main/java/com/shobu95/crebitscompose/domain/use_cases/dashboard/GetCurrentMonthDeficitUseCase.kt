package com.shobu95.crebitscompose.domain.use_cases.dashboard

import com.shobu95.crebitscompose.domain.model.Transaction
import com.shobu95.crebitscompose.domain.utils.DateTimeHelpers

class GetCurrentMonthDeficitUseCase {

    operator fun invoke(transactions: List<Transaction>): Int {
        val currentMonth = DateTimeHelpers.getCurrentMonth()

        val currentMonthTransactions = transactions.filter { transaction ->
            try {
                val monthOfTransaction = transaction.date?.split('/')!![1]
                monthOfTransaction.toInt() == currentMonth
            } catch (e: Exception) {
                e.printStackTrace()
                return 0
            }
        }

        val creditTransactions = currentMonthTransactions.filter { transaction ->
            transaction.type.equals("Credit")
        }

        val debitTransactions = currentMonthTransactions.filter { transaction ->
            transaction.type.equals("Debit")
        }

        val creditTransactionSum = creditTransactions.sumOf { transaction ->
            transaction.amount?.toInt()!!
        }

        val debitTransactionSum = debitTransactions.sumOf { transaction ->
            transaction.amount?.toInt()!!
        }

        return creditTransactionSum - debitTransactionSum
    }
}