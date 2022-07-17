package com.shobu95.crebitscompose.domain.use_cases

import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.domain.model.TransactionData

class DeleteTransactionUseCase(
    private val repository: TransactionRepository,
) {

    suspend operator fun invoke(transactionData: TransactionData) {
        repository.delete(transactionData)
    }
}