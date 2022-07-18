package com.shobu95.crebitscompose.domain.use_cases.transaction

import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.domain.model.Transaction

class DeleteTransactionUseCase(
    private val repository: TransactionRepository,
) {

    suspend operator fun invoke(transactionData: Transaction) {
        repository.delete(transactionData)
    }
}