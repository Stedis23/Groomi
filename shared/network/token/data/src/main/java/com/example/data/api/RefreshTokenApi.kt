package ru.shiftlab.cftteam.shared.network.token.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import ru.shiftlab.cftteam.shared.network.token.data.dto.RefreshTokenDto
import ru.shiftlab.cftteam.shared.network.token.data.dto.TokenBundleDto

interface RefreshTokenApi {

	@POST("api/v1/user/token-refresh")
	suspend fun refresh(@Body refreshToken: RefreshTokenDto): TokenBundleDto
}