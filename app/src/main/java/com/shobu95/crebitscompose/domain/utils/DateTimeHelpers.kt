package com.shobu95.crebitscompose.domain.utils

import android.os.Build
import java.time.LocalDate

object DateTimeHelpers {

    fun getCurrentMonth(): Int {
        val date = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now()
        } else {
            return -1
        }
        return date.monthValue
    }
}