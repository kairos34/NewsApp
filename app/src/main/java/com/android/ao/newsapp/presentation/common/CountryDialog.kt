package com.android.ao.newsapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import java.util.*

/**
 * @author alper
 * Created 26.07.2022
 */
@Composable
fun CountryDialog(onDismiss: () -> Unit, onCountrySelected: (String) -> Unit) {

    val availableSources = listOf(
        "ae", "ar", "at", "au", "be", "bg", "br", "ca",
        "ch", "cn", "co", "cu", "cz", "de", "eg", "fr", "gb",
        "gr", "hk", "hu", "id", "ie", "il", "in", "it", "jp",
        "kr", "lt", "lv", "ma", "mx", "my", "ng", "nl", "no",
        "nz", "ph", "pl", "pt", "ro", "rs", "ru", "sa", "se",
        "sg", "si", "sk", "th", "tr", "tw", "ua", "us", "ve", "za"
    )

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.secondary)
                ) {
                    Text(
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp).align(Center),
                        text = "Select Country",
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(availableSources.size) { index ->
                        TextButton(onClick = {
                            onCountrySelected(availableSources[index])
                            onDismiss()
                        }, modifier = Modifier.fillMaxWidth()) {
                            Text(
                                color = Color.White,
                                modifier = Modifier.padding(bottom = 8.dp),
                                text = Locale("", availableSources[index]).displayCountry,
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}