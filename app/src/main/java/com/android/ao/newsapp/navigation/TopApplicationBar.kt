package com.android.ao.newsapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.ao.newsapp.preferences.UserSettings
import com.android.ao.newsapp.presentation.common.CountryDialog
import java.util.*

/**
 * @author alper
 * Created 26.07.2022
 */
@Composable
fun TopApplicationBar(userSettings: UserSettings) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.secondary,
    ) {

        var openDialog by remember {
            mutableStateOf(false)
        }

        Text(
            text = Locale("", userSettings.country).displayCountry, style = MaterialTheme.typography.h6.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 4.dp),
            color = MaterialTheme.colors.onPrimary
        )
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = {
                openDialog = true
            }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Set source",
                )
            }
        }

        if (openDialog) {
            CountryDialog(userSettings.countryStream.collectAsState(),
            onDismiss =  {
                openDialog = false
            }) {
                userSettings.country = it
            }
        }
    }
}