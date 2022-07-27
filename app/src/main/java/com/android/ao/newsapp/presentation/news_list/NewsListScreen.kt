package com.android.ao.newsapp.presentation.news_list

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.ao.newsapp.presentation.common.ErrorView
import com.android.ao.newsapp.presentation.common.LoadingView
import com.android.ao.newsapp.presentation.news_list.components.CategorySelectionScreen
import com.android.ao.newsapp.presentation.news_list.components.NewsListItem
import com.android.ao.newsapp.presentation.news_list.components.SearchBar
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

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CategorySelectionScreen(viewModel.categoryState.collectAsState()) { category ->
                viewModel.refresh(
                    category = category
                )
            }
            SearchBar(viewModel.queryState.collectAsState()) { query ->
                viewModel.refresh(
                    query = query
                )
            }
            newsListState.news?.let {
                VerticalPager(count = it.size) { page ->
                    NewsListItem(it[page]) {
                        navigateToNewsDetail.invoke(page)
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
    }

}