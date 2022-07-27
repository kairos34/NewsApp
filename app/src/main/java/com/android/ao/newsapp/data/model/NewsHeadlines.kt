package com.android.ao.newsapp.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class NewsHeadlines(
    @SerializedName("articles")
    val news: List<News>,
    val status: String,
    val totalResults: Int
)