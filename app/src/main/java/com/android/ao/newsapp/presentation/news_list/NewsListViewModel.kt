package com.android.ao.newsapp.presentation.news_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.ao.newsapp.common.Resource
import com.android.ao.newsapp.domain.usecases.GetNewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * @author alper
 * Created 26.07.2022
 */
@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsListUseCase: GetNewsListUseCase
) : ViewModel() {

    private val _newsListState = MutableStateFlow(NewsListState())
    val newsListState: StateFlow<NewsListState> = _newsListState.asStateFlow()

    init {
        refresh()
    }

    fun refresh() {
        getNewsListUseCase("general").onEach { newsListResult ->
            when (newsListResult) {
                is Resource.Success -> {
                    _newsListState.value = NewsListState(
                        news = newsListResult.data
                    )
                }
                is Resource.Error -> {
                    _newsListState.value = NewsListState(
                        error = newsListResult.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _newsListState.value = NewsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}