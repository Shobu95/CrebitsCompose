package com.shobu95.crebitscompose.core.di

import android.app.Application
import androidx.room.Room
import com.shobu95.crebits.backend.local.TransactionDatabase
import com.shobu95.crebitscompose.data.repository.TransactionRepository
import com.shobu95.crebitscompose.data.repository.TransactionRepositoryImpl
import com.shobu95.crebitscompose.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesTransactionDb(context: Application): TransactionDatabase {
        return Room.databaseBuilder(
            context,
            TransactionDatabase::class.java,
            TransactionDatabase.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun providesTransactionRepository(database: TransactionDatabase): TransactionRepository {
        return TransactionRepositoryImpl(database.transactionDao)
    }


    @Provides
    @Singleton
    fun providesTransactionUseCases(repository: TransactionRepository): TransactionUseCases {
        return TransactionUseCases(
            getTransaction = GetTransactionUseCase(repository),
            deleteTransaction = DeleteTransactionUseCase(repository),
            addTransaction = AddTransactionUseCase(repository),
            getTransactionById = GetTransactionByIdUseCase(repository)
        )
    }

}