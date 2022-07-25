package com.android.ao.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class NewsHeadlines(
    @SerializedName("articles")
    val news: List<News>,
    val status: String,
    val totalResults: Int
)