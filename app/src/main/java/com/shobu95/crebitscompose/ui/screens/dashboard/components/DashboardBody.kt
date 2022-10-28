package com.shobu95.crebitscompose.ui.screens.dashboard.components

import DonutChart
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun DashboardBodyPrev() {
    DashboardBody()
}

@Composable
fun DashboardBody() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
    ) {

        Box(
        ) {

            DonutChart(
                points = listOf(40f, 60f),
                colors = listOf(Color.Black, Color.LightGray),
                modifier = Modifier.size(300.dp)
            )
            DonutData(modifier = Modifier.align(Center))

        }
        DeficitTile()
        TransactionTiles()
    }
}

@Composable
fun DonutData(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Crebits",
        fontSize = 20.sp
    )
}
