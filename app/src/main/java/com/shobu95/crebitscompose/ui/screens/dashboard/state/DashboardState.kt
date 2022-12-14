package com.shobu95.crebitscompose.ui.screens.dashboard.state

data class DashboardState(
    val graphData: Pair<Int, Int> = Pair(0, 0),
    val totalTransactions: Int = 0,
    val currentMonthDeficit: Int = 0
)
