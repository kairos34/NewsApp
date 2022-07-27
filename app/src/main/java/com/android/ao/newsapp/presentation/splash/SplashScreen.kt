package com.android.ao.newsapp.presentation.splash

import androidx.compose.runtime.Composable
import com.android.ao.newsapp.presentation.splash.components.AppDeveloperItem
import com.android.ao.newsapp.presentation.splash.components.AppLogoItem

/**
 * @author alper
 * Created 27.07.2022
 */
@Composable
fun SplashScreen(navigateToNewsList: () -> Unit) {
    AppLogoItem(navigateToNewsList)
    AppDeveloperItem()
}