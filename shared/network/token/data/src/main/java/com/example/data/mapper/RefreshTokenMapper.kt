package ru.shiftlab.cftteam.shared.network.token.data.mapper

import ru.shiftlab.cftteam.shared.network.token.data.dto.RefreshTokenDto

fun RefreshTokenDto.toStringEntity() = refreshToken

fun String.toRefreshTokenDto() = RefreshTokenDto(this)