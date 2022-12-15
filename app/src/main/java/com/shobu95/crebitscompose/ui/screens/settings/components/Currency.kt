package com.shobu95.crebitscompose.ui.screens.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Euro
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun OptionsPreview() {
    Column {
        DarkModeOptionPreview()
        CurrencyOption()
    }
}

@Composable
fun CurrencyOption() {
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
                .padding(start = 20.dp, end = 18.dp, top = 16.dp, bottom = 16.dp),
            verticalAlignment = CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Euro,
                tint = MaterialTheme.colors.secondary,
                contentDescription = "currency",
                modifier = Modifier.padding(end = 24.dp)
            )
            Text(
                text = "Currency",
                fontSize = 18.sp,
                modifier = Modifier
            )
            Text(
                text = "Rupees",
                textAlign = TextAlign.End,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .fillMaxWidth()

            )
        }
    }
}