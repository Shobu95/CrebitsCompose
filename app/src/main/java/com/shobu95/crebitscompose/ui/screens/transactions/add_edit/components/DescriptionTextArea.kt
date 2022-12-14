package com.shobu95.crebitscompose.ui.screens.transactions.add_edit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.AddEditTransactionViewModel
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.AddEditTransactionEvent
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.TextFieldState

@Composable
fun DescriptionTextArea(
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
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.secondary,
            focusedLabelColor = MaterialTheme.colors.secondary,
        ),
    )
}