package com.shobu95.crebitscompose.ui.screens.dashboard.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobu95.crebitscompose.ui.screens.dashboard.state.DashboardState
import com.shobu95.crebitscompose.ui.theme.ThemeBlack

@Preview
@Composable
fun DeficitTilePrev() {
    DeficitTile(DashboardState())
}

@Composable
fun DeficitTile(state: DashboardState) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(6.dp),
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            Text(
                text = "This Month's Deficit:",
                style = TextStyle(
                    color = ThemeBlack,
                    fontSize = 16.sp
                ),
                modifier = Modifier.width(100.dp)
            )

            Text(
                text = "Rs. ${state.currentMonthDeficit.toDouble()}",
                style = TextStyle(
                    color = ThemeBlack,
                    fontSize = 40.sp,
                    textAlign = TextAlign.End
                ),
                modifier = Modifier.align(
                    alignment = Alignment.BottomEnd
                )
            )
        }
    }
}