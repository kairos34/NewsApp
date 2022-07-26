package com.android.ao.newsapp.domain.usecases

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * @author alper
 * Created 26.07.2022
 */
class ParsePublishDate @Inject constructor() {
    @SuppressLint("SimpleDateFormat")
    operator fun invoke(date: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val outputFormat = SimpleDateFormat("HH:mm:ss, dd-MM-yyyy")
        val parsedDate: Date? = inputFormat.parse(date)
        return parsedDate?.run { outputFormat.format(parsedDate) } ?: date
    }
}