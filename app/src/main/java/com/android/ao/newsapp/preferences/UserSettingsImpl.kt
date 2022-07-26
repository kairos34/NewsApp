package com.android.ao.newsapp.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author alper
 * Created 26.07.2022
 */
class UserSettingsImpl @Inject constructor(
    @ApplicationContext context: Context
) : UserSettings {

    override val countryStream: MutableStateFlow<String>
    override var country: String by AppThemePreferenceDelegate("news_country", "gb")

    private val preferences: SharedPreferences =
        context.getSharedPreferences("user_settings", Context.MODE_PRIVATE)

    init {
        countryStream = MutableStateFlow(country)
    }

    inner class AppThemePreferenceDelegate(
        private val name: String,
        private val default: String,
    ) : ReadWriteProperty<Any?, String> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): String =
            preferences.getString(name, default)!!

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            countryStream.value = value
            preferences.edit {
                putString(name, value)
            }
        }
    }

}