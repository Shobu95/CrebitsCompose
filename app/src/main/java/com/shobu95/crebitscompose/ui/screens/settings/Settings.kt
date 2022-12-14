package com.shobu95.crebitscompose.ui.screens.settings

import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.screens.settings.components.SettingsScreenBody
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar
import com.shobu95.crebitscompose.ui.theme.ThemeBackgroundLight


@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen(HomeScreenItem.Settings.title)
}


@Composable
fun SettingsScreen(@StringRes title: Int) {
    Scaffold(
        backgroundColor = ThemeBackgroundLight,
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                showBackButton = false
            ) {}
        }
    ) {
        SettingsScreenBody()
    }
}