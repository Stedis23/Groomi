package com.example.domain.repository

import com.example.domain.entity.TokenBundleEntity

interface TokenRepository {

	suspend fun updateAccessToken(): String

	fun getAccessToken(): String

	fun checkTokenExists(): Boolean

	fun saveTokenBundle(tokenBundleEntity: TokenBundleEntity)

	fun clearTokenBundle()
}