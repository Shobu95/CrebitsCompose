package com.shobu95.crebitscompose.domain.use_cases

import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.domain.model.TransactionData

class GetTransactionByIdUseCase(
    private val repository: TransactionRepository,
) {
    suspend operator fun invoke(id: Int): TransactionData? {
        return repository.getById(id)
    }
}