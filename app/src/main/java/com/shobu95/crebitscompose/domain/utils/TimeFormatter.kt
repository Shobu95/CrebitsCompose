package com.shobu95.crebitscompose.domain.utils

import java.text.SimpleDateFormat
import java.util.*


fun getCurrentHourMinute(): Pair<Int, Int> {
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]
    return Pair(mHour, mMinute)
}


fun convertTo12Hour(_24HourTime: String): String {
    val _24HourSDF = SimpleDateFormat("HH:mm")
    val _12HourSDF = SimpleDateFormat("hh:mm a")
    val _24HourDt = _24HourSDF.parse(_24HourTime)
    return _12HourSDF.format(_24HourDt)
}