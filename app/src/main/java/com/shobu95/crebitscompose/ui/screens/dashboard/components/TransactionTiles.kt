package com.shobu95.crebitscompose.ui.screens.dashboard.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
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


@Preview
@Composable
fun TransactionTilesPrev() {
    TransactionTiles(DashboardState())
}

@Composable
fun TransactionTiles(state: DashboardState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 2.dp,
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
                .padding(6.dp)
        ) {
            Box(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Total Transactions:",
                    style = TextStyle(
                        color = MaterialTheme.colors.secondary,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.width(100.dp)
                )

                Text(
                    text = state.totalTransactions.toString(),
                    style = TextStyle(
                        color = MaterialTheme.colors.secondary,
                        fontSize = 40.sp,
                        textAlign = TextAlign.End
                    ),
                    modifier = Modifier.align(
                        alignment = Alignment.BottomEnd
                    )
                )
            }
        }

        Card(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 2.dp,
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
                .padding(6.dp)
        ) {
            Box(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Transactions This Month:",
                    style = TextStyle(
                        color = MaterialTheme.colors.secondary,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.width(100.dp)
                )

                Text(
                    text = state.currentMonthTransactions.toString(),
                    style = TextStyle(
                        color = MaterialTheme.colors.secondary,
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
}