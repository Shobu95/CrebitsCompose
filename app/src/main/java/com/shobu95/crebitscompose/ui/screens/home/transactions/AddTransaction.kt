package com.shobu95.crebitscompose.ui.screens.home.transactions

import android.os.Build
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shobu95.crebitscompose.domain.convertTo12Hour
import com.shobu95.crebitscompose.domain.getCurrentHourMinute
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.shared.CrebitsDatePicker
import com.shobu95.crebitscompose.ui.shared.CrebitsTimePicker
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar
import com.shobu95.crebitscompose.ui.theme.ThemeBlack
import com.shobu95.crebitscompose.ui.theme.ThemeWhite
import java.time.LocalDate

@Preview
@Composable
fun AddEditTransactionScreenPreview() {
    AddTransactionScreen(
        HomeScreenItem.AddTransaction.title,
        formState = TransactionFormState.ADD
    ) {}
}


@Composable
fun AddTransactionScreen(
    @StringRes title: Int,
    formState: TransactionFormState,
    onBackPressed: () -> Unit,
) {
    Scaffold(
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                true,
                onBackPressed
            )
        },
    ) {
        AddTransactionBody()
    }
}

@Composable
fun AddTransactionBody() {
    Column(
        modifier = Modifier.padding(14.dp)
    ) {

        CustomRadioGroup()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        EnterAmountTextField()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        TimeAndDateSelectors()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        EnterDescriptionTextArea()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        SaveButton()
    }
}

@Composable
fun CustomRadioGroup() {
    val options = listOf("Credit", "Debit")

    var selectedOption by remember {
        mutableStateOf("")
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
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
                        if (text == selectedOption) {
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
fun EnterAmountTextField() {
    var amount by remember { mutableStateOf("") }

    OutlinedTextField(
        value = amount,
        onValueChange = { amount = it },
        label = { Text(text = "Amount") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}

@Composable
fun TimeAndDateSelectors() {
    Row(Modifier.fillMaxWidth()) {

        TimePickerField(
            modifier = Modifier
                .weight(1F)
                .padding(end = 3.dp)
        )

        DatePickerField(
            modifier = Modifier
                .weight(1F)
                .padding(start = 3.dp)
        )
    }
}

@Composable
fun TimePickerField(modifier: Modifier) {
    val (mHour, mMinute) = getCurrentHourMinute()
    val mTime = remember {
        mutableStateOf(convertTo12Hour("$mHour:$mMinute"))
    }

    CrebitsTimePicker(
        value = mTime.value,
        onValueChange = { mTime.value = it },
        modifier = modifier
    )
}

@Composable
fun DatePickerField(modifier: Modifier) {
    val date = remember {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mutableStateOf(LocalDate.now())
        } else {
            return
        }
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        CrebitsDatePicker(
            value = date.value,
            onValueChange = { date.value = it },
            modifier = modifier
        )
    }
}

@Composable
fun EnterDescriptionTextArea() {
    var description by remember { mutableStateOf("") }

    OutlinedTextField(
        value = description,
        onValueChange = { description = it },
        label = { Text(text = "Description") },
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        maxLines = 5,
    )
}

@Composable
fun SaveButton() {
    Box(modifier = Modifier
        .fillMaxHeight()
        .padding(bottom = 10.dp)) {
        Button(
            onClick = {},
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ThemeBlack,
                contentColor = ThemeWhite
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .align(BottomCenter)
        ) {
            Text(text = "Save")
        }
    }
}
