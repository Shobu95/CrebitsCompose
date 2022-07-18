package com.shobu95.crebitscompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shobu95.crebitscompose.ui.screens.dashboard.DashboardScreen
import com.shobu95.crebitscompose.ui.screens.settings.SettingsScreen
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.AddEditTransactionScreen
import com.shobu95.crebitscompose.ui.screens.transactions.list.TransactionsScreen

@Composable
fun HomeNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeScreenItem.Dashboard.route) {

        composable(HomeScreenItem.Dashboard.route) {
            DashboardScreen(HomeScreenItem.Dashboard.title)
        }

        composable(HomeScreenItem.Transactions.route) {
            TransactionsScreen(HomeScreenItem.Transactions.title
            ) { navController.navigate(HomeScreenItem.AddTransaction.route) }
        }

        composable(HomeScreenItem.AddTransaction.route) {
            AddEditTransactionScreen(HomeScreenItem.AddTransaction.title) { navController.popBackStack() }
        }

        composable(HomeScreenItem.Settings.route) {
            SettingsScreen(HomeScreenItem.Settings.title)
        }
    }
}