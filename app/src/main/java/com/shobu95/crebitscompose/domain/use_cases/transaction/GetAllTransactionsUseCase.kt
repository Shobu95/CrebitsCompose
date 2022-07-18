package com.shobu95.crebitscompose.domain.use_cases.transaction

import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

class GetAllTransactionsUseCase(
    private val repository: TransactionRepository,
) {
    operator fun invoke(): Flow<List<Transaction>> {
        return repository.getAll()
    }
}