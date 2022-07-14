package com.shobu95.crebits.backend.local

import androidx.room.*
import com.shobu95.crebitscompose.data.model.TransactionData
import kotlinx.coroutines.flow.Flow


@Dao
interface TransactionDatabaseDao {

    /*
    * Transaction
    * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(transactionData: TransactionData): Long

    @Update
    fun update(transactionData: TransactionData): Int

    @Query("SELECT * FROM transaction_table ORDER BY id DESC")
    fun getAll(): Flow<List<TransactionData>>

    @Query("SELECT * FROM transaction_table WHERE id = :id")
    fun getById(id: Int): TransactionData?

    @Delete
    fun delete(transactionData: TransactionData)

}