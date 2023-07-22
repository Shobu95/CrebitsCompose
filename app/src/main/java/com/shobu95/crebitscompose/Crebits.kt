package com.shobu95.crebitscompose

import android.app.Application
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import com.shobu95.crebitscompose.data.datastore.CrebitsDatastore
import com.shobu95.crebitscompose.data.datastore.DatastoreKeys
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltAndroidApp
class Crebits : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalScope.launch {
            CrebitsDatastore.getBooleanData(applicationContext, DatastoreKeys.IS_DARK_MODE)
                .collectLatest { it ->
                    if (isDarkThemeOn() || it)
                        Log.v("DARK_THEME", it.toString())
                    else
                        Log.v("DARK_THEME", it.toString())
                }
        }

    }

    private fun isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES
    }
}
