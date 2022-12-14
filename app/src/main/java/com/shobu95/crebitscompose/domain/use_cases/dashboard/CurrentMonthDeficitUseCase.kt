package com.shobu95.crebitscompose.domain.use_cases.dashboard

import com.shobu95.crebitscompose.domain.model.Transaction

class CurrentMonthDeficitUseCase {

    operator fun invoke(currentMonthTransactions: List<Transaction>): Int {

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