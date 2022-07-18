package com.shobu95.crebits.backend.local

import androidx.room.*
import com.shobu95.crebitscompose.domain.model.Transaction
import kotlinx.coroutines.flow.Flow


@Dao
interface TransactionDao {

    /*
    * Transaction
    * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(transactionData: Transaction)

    @Update
    suspend fun update(transactionData: Transaction)

    @Query("SELECT * FROM transaction_table")
    fun getAll(): Flow<List<Transaction>>

    @Query("SELECT * FROM transaction_table WHERE id = :id")
    suspend fun getById(id: Int): Transaction?

    @Delete
    suspend fun delete(transactionData: Transaction)

}