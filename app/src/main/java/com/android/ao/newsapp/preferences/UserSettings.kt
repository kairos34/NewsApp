package com.android.ao.newsapp.preferences

import kotlinx.coroutines.flow.StateFlow

/**
 * @author alper
 * Created 26.07.2022
 */
interface UserSettings {
    val countryStream: StateFlow<String>
    var country: String
}