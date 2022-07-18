package com.shobu95.crebitscompose.ui.screens.dashboard.components

import DonutChart
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DashboardBody() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
    ) {
        DonutChart(
            points = listOf(40f, 60f),
            colors = listOf(Color.Black, Color.LightGray),
            modifier = Modifier.size(300.dp)
        )
        DeficitTile()
        TransactionTiles()
    }
}
