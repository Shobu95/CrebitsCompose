package com.shobu95.crebitscompose.ui.screens.transactions.add_edit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.AddEditTransactionViewModel

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

        CrebitsRadioGroup(typeState, viewModel)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        AmountTextField(amountState, viewModel)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        TimeAndDateSelectors(timeState, dateState, viewModel)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        DescriptionTextArea(descState, viewModel)
        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        SaveButton(viewModel)
    }
}