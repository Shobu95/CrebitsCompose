package com.shobu95.crebitscompose.ui.screens.dashboard

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.screens.dashboard.components.DashboardBody
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar

@Preview
@Composable
fun DashboardPreview() {
    DashboardScreen(HomeScreenItem.Dashboard.title)
}

@Composable
fun DashboardScreen(
    @StringRes title: Int,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        backgroundColor = MaterialTheme.colors.surface,
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                false
            ) {}
        }
    ) {
        DashboardBody(state)
    }

}





