package com.shobu95.crebitscompose.ui.shared

import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import com.shobu95.crebitscompose.domain.utils.convertTo12Hour
import com.shobu95.crebitscompose.domain.utils.getCurrentHourMinute

@Composable
fun CrebitsTimePicker(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    // Fetching local context
    val mContext = LocalContext.current
    val focusManager = LocalFocusManager.current
    val (mHour, mMinute) = getCurrentHourMinute()

    val timePickerDialog = TimePickerDialog(
        mContext,
        { _, mHour: Int, mMinute: Int ->
            onValueChange(convertTo12Hour("$mHour:$mMinute"))
            focusManager.clearFocus()
        }, mHour, mMinute, false
    ).apply {
        setOnDismissListener {
            focusManager.clearFocus()
        }
    }

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = "Time") },
        modifier = modifier
            .onFocusChanged {
                if (it.isFocused)
                    timePickerDialog.show()
                else
                    timePickerDialog.dismiss()
            },
        readOnly = true,
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.AccessTime,
                contentDescription = "Select Time",
                modifier = Modifier.clickable {
                    timePickerDialog.show()
                }
            )
        }
    )
}