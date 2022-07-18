package com.shobu95.crebitscompose.data.repository

import com.shobu95.crebits.backend.local.TransactionDao
import com.shobu95.crebitscompose.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

class TransactionRepositoryImpl(
    private val transactionDao: TransactionDao,
) : TransactionRepository {

    override fun getAll(): Flow<List<Transaction>> {
        return transactionDao.getAll()
    }

    override suspend fun getById(id: Int): Transaction? {
        return transactionDao.getById(id)
    }

    override suspend fun insert(transactionData: Transaction) {
        return transactionDao.insert(transactionData)
    }

    override suspend fun update(transactionData: Transaction) {
        return transactionDao.update(transactionData)
    }

    override suspend fun delete(transactionData: Transaction) {
        return transactionDao.delete(transactionData)
    }
}