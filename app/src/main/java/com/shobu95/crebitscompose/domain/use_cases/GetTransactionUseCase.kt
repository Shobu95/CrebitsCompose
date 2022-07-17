package com.shobu95.crebitscompose.domain.use_cases

import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.domain.model.TransactionData
import kotlinx.coroutines.flow.Flow

class GetTransactionUseCase(
    private val repository: TransactionRepository,
) {
    operator fun invoke(): Flow<List<TransactionData>> {
        return repository.getAll()
    }
}