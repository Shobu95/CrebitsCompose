package com.shobu95.crebitscompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun DarkModeOptionPreview() {
    DarkModeOption({})
}

@Composable
fun DarkModeOption(onCheckChanged: (isDark: Boolean) -> Unit) {

    val checkedState = remember { mutableStateOf(false) }


    Card(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 40.dp, top = 5.dp, bottom = 5.dp),
            verticalAlignment = CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.DarkMode,
                tint = MaterialTheme.colors.secondary,
                contentDescription = "dark mode",
                modifier = Modifier.padding(end = 24.dp)
            )
            Text(
                text = "Dark Mode",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 28.dp)
            )
            Switch(
                checked = checkedState.value,
                onCheckedChange = { onCheckChanged(it) }
            )
        }
    }
}