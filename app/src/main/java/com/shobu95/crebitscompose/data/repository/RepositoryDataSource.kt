package com.shobu95.crebits.backend.repository

import com.shobu95.crebitscompose.data.model.TransactionData
import kotlinx.coroutines.flow.Flow

interface RepositoryDataSource {

    /*
    * Get all TransactionData
    * */
    suspend fun getAllTransaction(): Flow<List<TransactionData>>

    suspend fun getTransactionByID(id: Int): TransactionData?

    suspend fun insertTransaction(transaction: TransactionData): Long

    suspend fun updateTransaction(transaction: TransactionData): Int

    suspend fun deleteTransaction(transaction: TransactionData)
    /*
    * Get all TransactionData End
    * */

}