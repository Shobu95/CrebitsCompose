package com.shobu95.crebitscompose.data.repository

import com.shobu95.crebits.backend.local.TransactionDao
import com.shobu95.crebitscompose.data.model.TransactionData
import kotlinx.coroutines.flow.Flow

class TransactionRepositoryImpl(
    private val transactionDao: TransactionDao,
) : TransactionRepository {

    override fun getAll(): Flow<List<TransactionData>> {
        return transactionDao.getAll()
    }

    override suspend fun getById(id: Int): TransactionData? {
        return transactionDao.getById(id)
    }

    override suspend fun insert(transactionData: TransactionData) {
        return transactionDao.insert(transactionData)
    }

    override suspend fun update(transactionData: TransactionData) {
        return transactionDao.update(transactionData)
    }

    override suspend fun delete(transactionData: TransactionData) {
        return transactionDao.delete(transactionData)
    }
}