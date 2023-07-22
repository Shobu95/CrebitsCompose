package com.shobu95.crebitscompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreenBody(onDarkModeChanged: (isDark: Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
    ) {
        DarkModeOption(onDarkModeChanged)
        CurrencyOption()
    }

}