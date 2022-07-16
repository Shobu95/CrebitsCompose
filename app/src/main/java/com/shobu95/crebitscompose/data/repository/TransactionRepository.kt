package com.shobu95.crebitscompose.data.repository

import com.shobu95.crebitscompose.data.model.TransactionData
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    fun getAll(): Flow<List<TransactionData>>

    suspend fun getById(id: Int): TransactionData?

    suspend fun insert(transactionData: TransactionData)

    suspend fun update(transactionData: TransactionData)

    suspend fun delete(transactionData: TransactionData)
}