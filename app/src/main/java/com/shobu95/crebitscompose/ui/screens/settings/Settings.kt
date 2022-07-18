package com.shobu95.crebitscompose.ui.screens.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Euro
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar
import com.shobu95.crebitscompose.ui.theme.ThemeBackground


@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen(HomeScreenItem.Settings.title)
}


@Composable
fun SettingsScreen(@StringRes title: Int) {
    Scaffold(
        backgroundColor = ThemeBackground,
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

@Composable
fun SettingsScreenBody() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)) {

        Card(
            elevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            Row(modifier = Modifier
                .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.DarkMode,
                    contentDescription = "dark mode",
                    modifier = Modifier.padding(end = 24.dp)
                )
                Text(text = "Dark Mode", fontSize = 18.sp)
            }
        }

        Card(
            elevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            Row(modifier = Modifier
                .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Euro,
                    contentDescription = "dark mode",
                    modifier = Modifier.padding(end = 24.dp)
                )
                Text(text = "Currency", fontSize = 18.sp)
            }
        }

    }

}