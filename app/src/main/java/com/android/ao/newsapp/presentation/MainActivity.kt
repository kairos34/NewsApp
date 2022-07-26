package com.android.ao.newsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.android.ao.newsapp.navigation.NavGraph
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
                // A surface container using the 'background' color from the theme
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = { TopApplicationBar(userSettings) },
                    backgroundColor = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavGraph(navController)
                }
            }
        }
    }
}