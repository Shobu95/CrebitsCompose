package com.shobu95.crebitscompose.ui.screens.transactions.add_edit.components

import android.os.Build
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.AddEditTransactionViewModel
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.AddEditTransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.TextFieldState
import com.shobu95.crebitscompose.ui.shared.CrebitsDatePicker
import com.shobu95.crebitscompose.ui.shared.CrebitsTimePicker

@Composable
fun TimeAndDateSelectors(
    timeState: TextFieldState,
    dateState: TextFieldState,
    viewModel: AddEditTransactionViewModel,
) {
    Row(Modifier.fillMaxWidth()) {

        TimePickerField(
            timeState = timeState,
            viewModel = viewModel,
            modifier = Modifier
                .weight(1F)
                .padding(end = 3.dp)
        )

        DatePickerField(
            dateState = dateState,
            viewModel = viewModel,
            modifier = Modifier
                .weight(1F)
                .padding(start = 3.dp)
        )
    }
}

@Composable
fun TimePickerField(
    modifier: Modifier,
    timeState: TextFieldState,
    viewModel: AddEditTransactionViewModel,
) {
//    val (mHour, mMinute) = getCurrentHourMinute()
//    val mTime = remember {
//        mutableStateOf(convertTo12Hour("$mHour:$mMinute"))
//    }
//
//    // set current time by default
//    viewModel.onEvent(AddEditTransactionEvent.EnteredTime(mTime.value))

    CrebitsTimePicker(
        value = timeState.text,
        onValueChange = {
            viewModel.onEvent(AddEditTransactionEvent.EnteredTime(it))
        },
        modifier = modifier
    )
}

@Composable
fun DatePickerField(
    modifier: Modifier,
    dateState: TextFieldState,
    viewModel: AddEditTransactionViewModel,
) {

//    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
//    val date = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        mutableStateOf(LocalDate.now())
//    } else {
//        return
//    }
//
//    viewModel.onEvent(AddEditTransactionEvent.EnteredDate(date.value))


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        CrebitsDatePicker(
            value = dateState.text,
            onValueChange = {
                viewModel.onEvent(AddEditTransactionEvent.EnteredDate(it))
            },
            modifier = modifier
        )
    }
}