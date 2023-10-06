package com.example.data.datasource

import ru.shiftlab.cftteam.shared.network.token.data.dto.RefreshTokenDto
import ru.shiftlab.cftteam.shared.network.token.data.dto.TokenBundleDto

interface RemoteTokenDataSource {

	suspend fun refresh(refreshTokenDto: RefreshTokenDto): TokenBundleDto
}