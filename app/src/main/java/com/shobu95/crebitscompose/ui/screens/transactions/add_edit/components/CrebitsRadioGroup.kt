package com.shobu95.crebitscompose.ui.screens.transactions.add_edit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.AddEditTransactionViewModel
import com.shobu95.crebitscompose.ui.screens.transactions.add_edit.state.AddEditTransactionEvent

@Composable
fun CrebitsRadioGroup(
    typeState: String,
    viewModel: AddEditTransactionViewModel
) {

    val options = listOf("Credit", "Debit")

    val onSelectionChange = { text: String ->
        viewModel.onEvent(AddEditTransactionEvent.ChangeType(text))
    }

    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 4.dp)
    ) {
        options.forEach { text ->
            Box(
                contentAlignment = Alignment.Center,
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
                    style = MaterialTheme.typography.body1.merge(),
                    color = Color.White,
                    modifier = Modifier.padding(
                        vertical = 12.dp
                    )
                )
            }
        }
    }
}