package ru.shiftlab.cftteam.shared.network.token.data.mapper

import ru.shiftlab.cftteam.shared.network.token.data.dto.TokenBundleDto
import com.example.domain.entity.TokenBundleEntity

fun TokenBundleDto.toEntity() = TokenBundleEntity(
	accessToken = accessToken,
	refreshToken = refreshToken
)

fun TokenBundleEntity.toDto() = TokenBundleDto(
	accessToken = accessToken,
	refreshToken = refreshToken
)