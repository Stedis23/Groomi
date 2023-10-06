package com.example.data.datasource

import ru.shiftlab.cftteam.shared.network.token.data.dto.TokenBundleDto

interface LocalTokenDataSource {

	fun checkTokenExist(): Boolean
	fun getAccessToken(): String
	fun getRefreshToken(): String
	fun saveTokenBundle(tokenBundleDto: TokenBundleDto)
	fun clear()
}