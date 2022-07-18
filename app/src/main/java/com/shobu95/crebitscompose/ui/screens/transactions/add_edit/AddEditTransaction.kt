package com.shobu95.crebitscompose.ui.screens.transactions.add_edit

import android.os.Build
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.AddEditTransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.TextFieldState
import com.shobu95.crebitscompose.ui.shared.CrebitsDatePicker
import com.shobu95.crebitscompose.ui.shared.CrebitsTimePicker
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar
import com.shobu95.crebitscompose.ui.theme.ThemeBackground
import com.shobu95.crebitscompose.ui.theme.ThemeBlack
import com.shobu95.crebitscompose.ui.theme.ThemeWhite
import kotlinx.coroutines.flow.collectLatest

@Preview
@Composable
fun AddEditTransactionScreenPreview() {
    AddEditTransactionScreen(
        HomeScreenItem.AddTransaction.title,
    ) {}
}


@Composable
fun AddEditTransactionScreen(
    @StringRes title: Int,
    viewModel: AddEditTransactionViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
) {

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {

                is AddEditTransactionViewModel.UiEvent.SaveTransaction -> {
                    navigateBack()
                }

                is AddEditTransactionViewModel.UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = ThemeBackground,
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                true,
                navigateBack
            )
        },
    ) {
        AddTransactionBody(viewModel)
    }
}

@Composable
fun AddTransactionBody(viewModel: AddEditTransactionViewModel) {
    Column(
        modifier = Modifier.padding(14.dp)
    ) {

        val typeState = viewModel.type.value
        val amountState = viewModel.amountText.value
        val timeState = viewModel.timeText.value
        val dateState = viewModel.dateText.value
        val descState = viewModel.descText.value

        CustomRadioGroup(typeState, viewModel)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        EnterAmountTextField(amountState, viewModel)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        TimeAndDateSelectors(timeState, dateState, viewModel)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        EnterDescriptionTextArea(descState, viewModel)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        SaveButton(viewModel)
    }
}

@Composable
fun CustomRadioGroup(typeState: String, viewModel: AddEditTransactionViewModel) {

    val options = listOf("Credit", "Debit")

    val onSelectionChange = { text: String ->
        viewModel.onEvent(AddEditTransactionEvent.ChangeType(text))
    }

    Row(Modifier
        .fillMaxWidth()
        .padding(top = 4.dp)) {
        options.forEach { text ->
            Box(
                contentAlignment = Center,
                modifier = Modifier
                    .weight(1F)
                    .padding(horizontal = 2.dp)
                    .background(
                        if (text == typeState) {
                            Color.Black
                        } else {
                            Color.LightGray
                        }
                    )
                    .clickable {
                        onSelectionChange(text)
                    }
            ) {
                Text(
                    text = text,
                    style = typography.body1.merge(),
                    color = Color.White,
                    modifier = Modifier.padding(
                        vertical = 12.dp
                    )
                )
            }
        }
    }
}

@Composable
fun EnterAmountTextField(amountState: TextFieldState, viewModel: AddEditTransactionViewModel) {

    OutlinedTextField(
        value = amountState.text,
        onValueChange = {
            viewModel.onEvent(AddEditTransactionEvent.EnteredAmount(it))
        },
        label = { Text(text = "Amount") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}


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


@Composable
fun EnterDescriptionTextArea(
    descState: TextFieldState,
    viewModel: AddEditTransactionViewModel,
) {

    val descTextModifier = Modifier
        .fillMaxWidth()
        .height(120.dp)

    OutlinedTextField(
        value = descState.text,
        onValueChange = {
            viewModel.onEvent(AddEditTransactionEvent.EnteredDescription(it))
        },
        label = { Text(text = "Description") },
        modifier = descTextModifier,
        maxLines = 5,
    )
}


@Composable
fun SaveButton(viewModel: AddEditTransactionViewModel) {

    val boxModifier = Modifier
        .fillMaxHeight()
        .padding(bottom = 10.dp)

    val buttonModifier = Modifier
        .fillMaxWidth()
        .height(46.dp)


    Box(modifier = boxModifier) {
        Button(
            onClick = {
                viewModel.onEvent(AddEditTransactionEvent.SaveTransaction)
            },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ThemeBlack,
                contentColor = ThemeWhite
            ),
            modifier = buttonModifier.align(BottomCenter),
        ) {
            Text(text = "Save")
        }
    }
}
