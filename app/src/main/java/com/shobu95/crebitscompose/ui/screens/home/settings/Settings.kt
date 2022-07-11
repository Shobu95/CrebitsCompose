package com.shobu95.crebitscompose.ui.screens.home.settings

import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar

@Composable
fun SettingsScreen(@StringRes title: Int) {
    Scaffold(
        topBar = { CrebitsTopAppBar(title = stringResource(id = title), false) {} }
    ) {

    }
}

@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen(HomeScreenItem.Settings.title)
}