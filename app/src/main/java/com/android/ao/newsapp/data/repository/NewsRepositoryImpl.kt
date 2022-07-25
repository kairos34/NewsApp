package com.android.ao.newsapp.data.repository

import com.android.ao.newsapp.data.model.NewsHeadlines
import com.android.ao.newsapp.data.remote.NewsService
import com.android.ao.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

/**
 * @author alper
 * Created 25.07.2022
 */
class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
): NewsRepository {
    override suspend fun getNews(
        country: String,
        category: String,
        query: String
    ): NewsHeadlines = newsService.getTopHeadlines(
        country,
        category,
        query
    )
}