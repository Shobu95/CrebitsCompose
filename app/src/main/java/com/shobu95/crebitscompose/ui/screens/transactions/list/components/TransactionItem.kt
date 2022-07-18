package com.shobu95.crebitscompose.ui.screens.transactions.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shobu95.crebitscompose.R
import com.shobu95.crebitscompose.domain.model.Transaction

@Preview
@Composable
fun TransactionItemPrev() {
//    TransactionItem()
}

@Composable
fun TransactionItem(
    transaction: Transaction,
    onDeleteClick: () -> Unit,
    onEditClick: () -> Unit,
) {

    Card(
        elevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(4.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_downward
                ),
                contentDescription = "Transaction Icon"
            )

            Text(
                text = transaction.amount.toString(),
            )

            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Delete button"
                )
            }

            IconButton(onClick = onEditClick) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Edit button"
                )
            }
        }
    }

}