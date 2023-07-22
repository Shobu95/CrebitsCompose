package com.shobu95.crebitscompose.ui.screens.settings

import androidx.lifecycle.ViewModel
import com.shobu95.crebitscompose.domain.use_cases.settings.SettingsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel
@Inject constructor(
    private val settingsUseCases: SettingsUseCases
) : ViewModel() {

    fun onDarkModeChanged(isDark: Boolean) {
        settingsUseCases.darkModeUseCase(isDark)
    }
}