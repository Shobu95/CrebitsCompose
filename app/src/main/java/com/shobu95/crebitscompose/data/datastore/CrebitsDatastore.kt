package com.shobu95.crebitscompose.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

object CrebitsDatastore {

    private val Context.crebitsDatastore: DataStore<Preferences> by preferencesDataStore(name = DatastoreKeys.DATASTORE_NAME)

    suspend fun setBooleanData(context: Context, key: String, value: Boolean) {
        val KEY = booleanPreferencesKey(key)
        context.crebitsDatastore.edit { prefs ->
            prefs[KEY] = value
        }
    }

    fun getBooleanData(context: Context, key: String): Flow<Boolean> {
        try {
            val KEY = booleanPreferencesKey(key)
            return context.crebitsDatastore.data.map { prefs ->
                prefs[KEY] ?: false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return flow { false }
        }
    }

}

object DatastoreKeys {

    val DATASTORE_NAME = "CREBITS_DATASTORE"
    val IS_DARK_MODE = "IS_DARK_MODE"

}