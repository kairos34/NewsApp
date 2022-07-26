package com.android.ao.newsapp.presentation.news_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.ao.newsapp.presentation.common.ErrorView
import com.android.ao.newsapp.presentation.common.LoadingView
import com.android.ao.newsapp.presentation.news_list.components.NewsListItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager

/**
 * @author alper
 * Created 26.07.2022
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun NewsListScreen(
    viewModel: NewsListViewModel,
    navigateToNewsDetail: (Int) -> Unit,
) {
    val newsListState by viewModel.newsListState.collectAsState()

    newsListState.news?.let {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VerticalPager(count = it.size) { page ->
                    NewsListItem(it[page]) {
                        navigateToNewsDetail.invoke(page)
                    }
                }
            }
        }
    }
    if (newsListState.error.isNotBlank()) {
        ErrorView(
            message = newsListState.error,
            onClickRetry = { viewModel.refresh() }
        )
    }
    if (newsListState.isLoading) {
        LoadingView()
    }

}