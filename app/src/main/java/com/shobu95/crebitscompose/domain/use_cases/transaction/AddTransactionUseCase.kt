package com.shobu95.crebitscompose.domain.use_cases.transaction

import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.domain.model.InvalidTransactionException
import com.shobu95.crebitscompose.domain.model.Transaction

class AddTransactionUseCase(
    private val repository: TransactionRepository,
) {

    @Throws(InvalidTransactionException::class)
    suspend operator fun invoke(transactionData: Transaction) {

        if (transactionData.amount.isNullOrBlank()) {
            throw InvalidTransactionException("Amount cannot be empty")
        }

        repository.insert(transactionData)
    }

}