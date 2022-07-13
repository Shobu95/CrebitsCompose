package com.shobu95.crebitscompose.ui.screens.home.dashboard

import CrebitsDonutChart
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
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
import com.shobu95.crebitscompose.ui.theme.ThemeBackground


@Preview
@Composable
fun DashboardPreview() {
    DashboardScreen(HomeScreenItem.Dashboard.title)
}

@Composable
fun DashboardScreen(@StringRes title: Int) {
    Scaffold(
        backgroundColor = ThemeBackground,
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
            .fillMaxSize()
            .padding(14.dp)
    ) {
        CrebitsDonutChart(
            points = listOf(40f, 60f),
            colors = listOf(Color.Black, Color.LightGray),
            modifier = Modifier.size(300.dp)
        )

        InformationTiles()
    }
}

@Composable
fun InformationTiles() {
    Column {
        Deficit()
        TransactionCards()
    }

}

@Composable
fun Deficit() {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(6.dp),
    ) {}
}

@Composable
fun TransactionCards() {
    Row(modifier = Modifier
        .fillMaxWidth()
    ) {
        Card(
            elevation = 2.dp,
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
                .padding(6.dp)
        ) {}

        Card(
            elevation = 2.dp,
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
                .padding(6.dp)
        ) {}

    }
}



