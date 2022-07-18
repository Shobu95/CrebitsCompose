package com.shobu95.crebitscompose.domain.use_cases.transaction

import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.domain.model.Transaction

class GetTransactionByIdUseCase(
    private val repository: TransactionRepository,
) {
    suspend operator fun invoke(id: Int): Transaction? {
        return repository.getById(id)
    }
}