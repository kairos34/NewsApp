package com.android.ao.newsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.ao.newsapp.navigation.NavGraph
import com.android.ao.newsapp.navigation.Screen
import com.android.ao.newsapp.navigation.TopApplicationBar
import com.android.ao.newsapp.preferences.UserSettings
import com.android.ao.newsapp.presentation.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * @author alper
 * Created 25.07.2022
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var userSettings: UserSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                val topBarState = rememberSaveable { (mutableStateOf(false)) }
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()

                when (navBackStackEntry?.destination?.route) {
                    Screen.NewsListScreen.route -> topBarState.value = true
                    else -> topBarState.value = false
                }

                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { TopApplicationBar(userSettings, topBarState) },
                    backgroundColor = MaterialTheme.colors.background) {
                    NavGraph(navController)
                }
            }
        }
    }
}