package com.android.ao.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.ao.newsapp.common.Constants
import com.android.ao.newsapp.presentation.news_detail.NewsDetailScreen
import com.android.ao.newsapp.presentation.news_list.NewsListScreen
import com.android.ao.newsapp.presentation.news_list.NewsListViewModel
import com.android.ao.newsapp.presentation.splash.SplashScreen

/**
 * @author alper
 * Created 26.07.2022
 */
@Composable
fun NavGraph(navController: NavHostController,
             newsListViewModel: NewsListViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
    ) {
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen {
                navController.navigate(Screen.NewsListScreen.route) {
                    popUpTo(Screen.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = Screen.NewsListScreen.route) {
            NewsListScreen(newsListViewModel) {
                navController.navigate(Screen.NewsDetailScreen.route + "/${it}")
            }
        }
        composable(
            route = Screen.NewsDetailScreen.route + "/{${Constants.PARAM_NEWS_INDEX}}"
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getString(Constants.PARAM_NEWS_INDEX)?.toInt() ?: 0
            newsListViewModel.newsListState.collectAsState().value.news?.get(index)?.run {
                NewsDetailScreen(this)
            }
        }
    }
}