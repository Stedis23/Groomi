package com.example.welcome.data

import android.content.Context
import com.example.storege.PreferenceKeys.WELCOME_SKIP_VALUE
import com.example.storege.PreferenceNames.WELCOME_PREF
import com.example.welcome.domain.datasource.SkipWelcomeSharedPrefDataSource

class SkipWelcomeSharedPrefDataSourceImpl(private val context: Context) : SkipWelcomeSharedPrefDataSource {

	override fun insert() {
		with(context.getSharedPreferences(WELCOME_PREF, Context.MODE_PRIVATE).edit()) {
			putBoolean(WELCOME_SKIP_VALUE, true)
			commit()
		}
	}

	override fun get(): Boolean {
		val sharedPref = context.getSharedPreferences(WELCOME_PREF, Context.MODE_PRIVATE)
		return sharedPref.getBoolean(WELCOME_SKIP_VALUE, false)
	}
}