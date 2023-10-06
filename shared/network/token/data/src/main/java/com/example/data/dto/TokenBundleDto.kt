package ru.shiftlab.cftteam.shared.network.token.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenBundleDto(
	@Json(name = "jwt") val accessToken: String,
	@Json(name = "refreshToken") val refreshToken: String
)