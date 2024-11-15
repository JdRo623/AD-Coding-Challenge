package com.joanDuarte.admobiletest.presentation.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date
import java.util.Locale

class DateFormatter(
    private val date: String) {
    operator fun invoke(): String {
        val format = "yyyy-MM-dd'T'HH:mm:ss'Z'"

        val sdf = SimpleDateFormat(format, Locale.US)
        val currentDate = sdf.parse(date)
        val diff = Calendar.getInstance().time.time - (currentDate?.time ?: Calendar.getInstance().time.time )

        val oneSec = 1000L
        val oneMin: Long = 60 * oneSec
        val oneHour: Long = 60 * oneMin
        val oneDay: Long = 24 * oneHour
        val oneMonth: Long = 30 * oneDay
        val oneYear: Long = 365 * oneDay

        val diffMin: Long = diff / oneMin
        val diffHours: Long = diff / oneHour
        val diffDays: Long = diff / oneDay
        val diffMonths: Long = diff / oneMonth
        val diffYears: Long = diff / oneYear

        return when {
            diffYears > 0 -> {
                 "$diffYears years ago"
            }
            diffMonths > 0-> {
                 "${(diffMonths - diffYears / 12)} months ago "
            }
            diffDays > 0-> {
                "${(diffDays - diffMonths / 30)} days ago "
            }
            diffHours > 0-> {
                "${(diffHours - diffDays * 24)} hours ago "
            }
            diffMin > 0-> {
                "${(diffMin - diffHours * 60)} min ago "
            }
            else -> {
                "$ just now"
            }
        }
    }
}