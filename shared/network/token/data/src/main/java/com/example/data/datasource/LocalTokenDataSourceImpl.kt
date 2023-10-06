package com.example.data.datasource

import android.content.Context
import android.content.Context.*
import android.content.SharedPreferences
import androidx.core.content.edit
import ru.shiftlab.cftteam.shared.network.token.data.dto.TokenBundleDto

class LocalTokenDataSourceImpl(
	private val sharedPreferences: SharedPreferences
) : LocalTokenDataSource {

	companion object {

		private const val TOKEN_PREFERENCES = "TOKEN_PREFERENCES"
		private const val ACCESS_TOKEN = "ACCESS_TOKEN"
		private const val REFRESH_TOKEN = "REFRESH_TOKEN"

		fun getSharedPreferences(context: Context): SharedPreferences =
			context.getSharedPreferences(TOKEN_PREFERENCES, MODE_PRIVATE)
	}

	override fun checkTokenExist(): Boolean =
		!sharedPreferences.getString(ACCESS_TOKEN, null).isNullOrEmpty() &&
			!sharedPreferences.getString(REFRESH_TOKEN, null).isNullOrEmpty()

	override fun getAccessToken(): String =
		sharedPreferences.getString(ACCESS_TOKEN, null) ?: throw IllegalStateException("access token doesn't exists")

	override fun getRefreshToken(): String =
		sharedPreferences.getString(REFRESH_TOKEN, null) ?: throw IllegalStateException("refresh token doesn't exists")

	override fun saveTokenBundle(tokenBundleDto: TokenBundleDto) {
		sharedPreferences.edit(commit = true) {
			putString(ACCESS_TOKEN, tokenBundleDto.accessToken)
			putString(REFRESH_TOKEN, tokenBundleDto.refreshToken)
		}
	}

	override fun clear() {
		sharedPreferences.edit(commit = true) {
			remove(ACCESS_TOKEN)
			remove(REFRESH_TOKEN)
		}
	}
}