package com.android.ao.newsapp.navigation

sealed class Screen(val route: String) {
    object NewsListScreen : Screen("news_list_screen")
    object NewsDetailScreen: Screen("news_detail_screen")
    object SplashScreen: Screen("splash_screen")
}