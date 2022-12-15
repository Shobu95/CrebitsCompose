package com.shobu95.crebitscompose.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CrebitsDatastore @Inject constructor(
    @ApplicationContext val context: Context
) {

    private val Context.crebitsDatastore: DataStore<Preferences> by preferencesDataStore(name = "crebits_datastore")

    suspend fun setStringData(key: String, value: Boolean) {
        val KEY = booleanPreferencesKey(key)
        context.crebitsDatastore.edit { prefs ->
            prefs[KEY] = value
        }
    }

    fun getStringData(key: String): Flow<Boolean> {
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