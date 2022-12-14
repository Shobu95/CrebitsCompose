package com.shobu95.crebitscompose.domain.use_cases.dashboard

import com.shobu95.crebitscompose.domain.model.Transaction

class GraphDataUseCase(
) {
    operator fun invoke(transactions: List<Transaction>): Pair<Int, Int> {
        var total = 0
        var credits = 0
        var debits = 0
        var creditPc = 0
        var debitPc = 0

        total = transactions.size
        if (total == 0) {
            return Pair(0, 0)
        }
        credits = transactions.filter { it.type == "Credit" }.size
        debits = transactions.filter { it.type == "Debit" }.size
        creditPc = ((credits.toDouble() / total) * 100).toInt()
        debitPc = ((debits.toDouble() / total) * 100).toInt()

        return Pair(creditPc, debitPc)
    }
}