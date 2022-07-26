package com.android.ao.newsapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.ao.newsapp.presentation.news_list.NewsListScreen

/**
 * @author alper
 * Created 26.07.2022
 */
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.NewsListScreen.route,
    ) {
        composable(route = Screen.NewsListScreen.route) {
            NewsListScreen()
        }
    }
}