package com.shobu95.crebits.backend.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shobu95.crebitscompose.data.model.TransactionData

/**
 * @author AliAzazAlam on 10/29/2021.
 */
@Database(
    entities = [TransactionData::class],
    version = 1,
    exportSchema = false
)
abstract class TransactionDatabase : RoomDatabase() {

    abstract fun vehicleDao(): TransactionDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: TransactionDatabase? = null

        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TransactionDatabase::class.java,
                "transaction_database"
            ).fallbackToDestructiveMigration().build()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

    }
}