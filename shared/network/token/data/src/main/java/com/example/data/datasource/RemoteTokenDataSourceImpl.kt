package com.example.data.datasource

import com.example.data.datasource.RemoteTokenDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.shiftlab.cftteam.shared.network.token.data.api.RefreshTokenApi
import ru.shiftlab.cftteam.shared.network.token.data.dto.RefreshTokenDto
import ru.shiftlab.cftteam.shared.network.token.data.dto.TokenBundleDto

class RemoteTokenDataSourceImpl(private val api: RefreshTokenApi) : RemoteTokenDataSource {

	override suspend fun refresh(
		refreshTokenDto: RefreshTokenDto
	): TokenBundleDto = withContext(Dispatchers.IO) {
		api.refresh(refreshTokenDto)
	}
}