package com.shobu95.crebitscompose.data.data_source.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shobu95.crebits.backend.local.TransactionDatabase
import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.data.repository.TransactionRepositoryImpl
import com.shobu95.crebitscompose.domain.model.Transaction
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TransactionDatabaseTest {

    lateinit var db: TransactionDatabase
    lateinit var transactionRepository: TransactionRepository

    @Before
    fun `initialize database`() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            TransactionDatabase::class.java
        ).build()

        transactionRepository = TransactionRepositoryImpl(db.transactionDao)

    }

    @Test
    fun `1- should initialize database`() {
        assertNotNull(db)
    }

    @Test
    fun `2- should initialize transaction repository `() {
        val transactionRepository = TransactionRepositoryImpl(db.transactionDao)
        assertNotNull(transactionRepository)
    }

    @Test
    fun `3- should insert transaction and get it by id`() {
        val transaction = Transaction(
            null,
            "Credit",
            "2000",
            "12/03/2022",
            "11:20 AM",
            "sample test description"
        )

        runBlocking {
            transactionRepository.insert(transaction)
            val testTransaction = transactionRepository.getById(1)
            assertEquals(testTransaction?.amount, "2000")
        }

    }

    @Test
    fun `4- should insert transaction and delete successfully`() {
        val transaction = Transaction(
            null,
            "Credit",
            "2000",
            "12/03/2022",
            "11:20 AM",
            "sample test description"
        )

        runBlocking {
            transactionRepository.insert(transaction)
        }

        runBlocking {
            val testTransaction = transactionRepository.getById(1)
            transactionRepository.delete(testTransaction!!)
            assertEquals(transactionRepository.getById(1), null)
        }
    }

    @Test
    fun `5- should insert transaction and update successfully`() {
        val transaction = Transaction(
            null,
            "Credit",
            "2000",
            "12/03/2022",
            "11:20 AM",
            "sample test description"
        )

        runBlocking {
            transactionRepository.insert(transaction)

            var testTransaction = transactionRepository.getById(1)
            testTransaction?.apply {
                amount = "3000"
                description = "updated description"
            }
            transactionRepository.update(testTransaction!!)

            var updatedTransaction = transactionRepository.getById(1)
            assertEquals(updatedTransaction?.amount, "3000")
            assertEquals(updatedTransaction?.description, "updated description")
        }
    }

    @Test
    fun `6- should upsert successfully`() {
        val transaction = Transaction(
            null,
            "Credit",
            "2000",
            "12/03/2022",
            "11:20 AM",
            "sample test description"
        )

        runBlocking {
            transactionRepository.insert(transaction)

            var testTransaction = transactionRepository.getById(1)
            testTransaction?.apply {
                amount = "1234"
                description = "nothing here"
            }
            transactionRepository.insert(testTransaction!!)

            var updatedTransaction = transactionRepository.getById(1)
            assertEquals(updatedTransaction?.amount, "1234")
            assertEquals(updatedTransaction?.description, "nothing here")
        }
    }


}