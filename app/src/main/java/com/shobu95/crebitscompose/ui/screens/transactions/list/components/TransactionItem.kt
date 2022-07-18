package com.shobu95.crebitscompose.ui.screens.transactions.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobu95.crebitscompose.R
import com.shobu95.crebitscompose.domain.model.Transaction

@Preview
@Composable
fun TransactionItemPrev() {
    TransactionItem(
        transaction = Transaction(
            null,
            "Credit",
            "2345",
            "12/12/2022",
            "11:00 AM",
            "This is a sample description"

        ),
        onDeleteClick = {},
        onEditClick = {}
    )
}

@Composable
fun TransactionItem(
    transaction: Transaction,
    onDeleteClick: () -> Unit,
    onEditClick: () -> Unit,
) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (transaction.type.equals("Debit")) {
                DebitIcon()
            } else {
                CreditIcon()
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
                Text(
                    text = "Rs.${transaction.amount}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${transaction.date} | ${transaction.time}",
                    color = Color.Gray
                )
            }

            IconButton(
                onClick = onDeleteClick
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Delete button",
                )
            }

        }
    }
}

@Composable
fun CreditIcon() {
    Icon(
        contentDescription = "Transaction Icon",
        modifier = Modifier.size(40.dp),
        painter = painterResource(
            id = R.drawable.ic_red_arrow_up,
        ),
        tint = Color.Red
    )
}


@Composable
fun DebitIcon() {
    Icon(
        contentDescription = "Transaction Icon",
        modifier = Modifier.size(40.dp),
        painter = painterResource(
            id = R.drawable.ic_green_arrow_down,
        ),
        tint = Color.Green
    )
}