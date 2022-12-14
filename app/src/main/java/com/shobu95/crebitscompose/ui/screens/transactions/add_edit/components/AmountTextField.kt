package com.shobu95.crebitscompose.ui.screens.transactions.add_edit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.AddEditTransactionViewModel
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.AddEditTransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.TextFieldState

@Composable
fun AmountTextField(
    amountState: TextFieldState,
    viewModel: AddEditTransactionViewModel
) {
    OutlinedTextField(
        value = amountState.text,
        onValueChange = {
            viewModel.onEvent(AddEditTransactionEvent.EnteredAmount(it))
        },
        label = { Text(text = "Amount") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.secondary,
            focusedLabelColor = MaterialTheme.colors.secondary,
        ),
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}