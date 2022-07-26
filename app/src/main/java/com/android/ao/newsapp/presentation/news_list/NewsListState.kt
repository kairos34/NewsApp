package com.android.ao.newsapp.presentation.news_list

import com.android.ao.newsapp.data.model.News

/**
 * @author alper
 * Created 26.07.2022
 */
data class NewsListState(
    val isLoading: Boolean = false,
    val news: List<News>? = null,
    val error: String = ""
)