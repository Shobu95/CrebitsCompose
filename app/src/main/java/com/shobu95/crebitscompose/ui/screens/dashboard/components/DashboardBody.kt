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
import com.shobu95.crebitscompose.ui.screens.dashboard.state.DashboardState


@Preview
@Composable
fun DashboardBodyPrev() {
    DashboardBody(DashboardState())
}

@Composable
fun DashboardBody(state: DashboardState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp)
    ) {

        Box() {
            DonutData(state)
            DonutChart(
                points = listOf(state.graphData.first, state.graphData.second) as List<Float>,
                colors = listOf(Color.Black, Color.LightGray),
                modifier = Modifier
                    .size(300.dp)
                    .align(Center)
            )
        }
        DeficitTile(state)
        TransactionTiles(state)
    }
}

@Composable
fun DonutData(
    state: DashboardState
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Debits ${state.graphData.second}%",
            fontSize = 16.sp
        )

        Text(
            text = "Credits ${state.graphData.first}%",
            fontSize = 16.sp
        )
    }


}
