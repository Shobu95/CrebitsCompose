package com.shobu95.crebitscompose.ui.screens.home.dashboard

import CrebitsDonutChart
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar


@Preview
@Composable
fun DashboardPreview() {
    DashboardScreen(HomeScreenItem.Dashboard.title)
}

@Composable
fun DashboardScreen(@StringRes title: Int) {
    Scaffold(
        topBar = { CrebitsTopAppBar(title = stringResource(id = title), false) {} }
    ) {
        DashboardBody()
    }

}

@Composable
fun DashboardBody() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        CrebitsDonutChart(
            points = listOf(40f, 60f),
            colors = listOf(Color.Black, Color.LightGray),
            modifier = Modifier.size(300.dp)
        )
    }
}



