package com.shobu95.crebits.backend.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shobu95.crebitscompose.domain.model.TransactionData

@Database(
    entities = [TransactionData::class],
    version = 1,
    exportSchema = false
)
abstract class TransactionDatabase : RoomDatabase() {

    abstract val transactionDao: TransactionDao

    companion object {
        const val DATABASE_NAME = "transaction_database"
    }
}