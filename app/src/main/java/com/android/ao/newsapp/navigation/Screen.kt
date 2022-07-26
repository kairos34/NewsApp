package com.android.ao.newsapp.navigation

sealed class Screen(val route: String) {
    object NewsListScreen : Screen("news_list_screen")
}