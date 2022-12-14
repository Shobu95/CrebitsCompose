package com.shobu95.crebitscompose.ui.screens.dashboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shobu95.crebitscompose.domain.use_cases.dashboard.DashboardUseCases
import com.shobu95.crebitscompose.ui.screens.dashboard.state.DashboardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardUseCase: DashboardUseCases
) : ViewModel() {

    private val _state = mutableStateOf(DashboardState())
    val state: State<DashboardState> = _state

    init {
        getGraphData()
    }

    private fun getGraphData() {
        viewModelScope.launch {
            dashboardUseCase.getAllTransactions().collectLatest {
                _state.value = state.value.copy(
                    totalTransactions = it.size,
                    graphData = dashboardUseCase.getGraphData(it),
                    currentMonthDeficit = dashboardUseCase.getCurrentMonthDeficit(it)
                )
            }

        }

    }

}
