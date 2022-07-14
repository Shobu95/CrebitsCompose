package com.shobu95.crebitscompose.ui.screens.home.settings

import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar
import com.shobu95.crebitscompose.ui.theme.ThemeBackground

@Composable
fun SettingsScreen(@StringRes title: Int) {
    Scaffold(
        backgroundColor = ThemeBackground,
        topBar = { CrebitsTopAppBar(title = stringResource(id = title), false) {} }
    ) {

    }
}

@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen(HomeScreenItem.Settings.title)
}