package com.shobu95.crebitscompose.domain.use_cases.settings

import android.app.UiModeManager
import android.os.Build
import androidx.annotation.RequiresApi
import javax.inject.Inject

class DarkModeUseCase
@Inject constructor(private val uiModeManager: UiModeManager) {
    @RequiresApi(Build.VERSION_CODES.S)
    operator fun invoke(isDark: Boolean) {
        if (isDark) uiModeManager.setApplicationNightMode(UiModeManager.MODE_NIGHT_YES)
        else uiModeManager.setApplicationNightMode(UiModeManager.MODE_NIGHT_NO)
    }
}