package com.android.ao.newsapp.data.model

import androidx.annotation.Keep

@Keep
data class News(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String?
)