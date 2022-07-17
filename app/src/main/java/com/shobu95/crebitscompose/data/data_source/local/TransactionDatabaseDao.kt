package com.shobu95.crebits.backend.local

import androidx.room.*
import com.shobu95.crebitscompose.domain.model.TransactionData
import kotlinx.coroutines.flow.Flow


@Dao
interface TransactionDao {

    /*
    * Transaction
    * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(transactionData: TransactionData)

    @Update
    suspend fun update(transactionData: TransactionData)

    @Query("SELECT * FROM transaction_table")
    fun getAll(): Flow<List<TransactionData>>

    @Query("SELECT * FROM transaction_table WHERE id = :id")
    suspend fun getById(id: Int): TransactionData?

    @Delete
    suspend fun delete(transactionData: TransactionData)

}