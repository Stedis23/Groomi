package com.example.domain.usecase

import com.example.domain.repository.TokenRepository

class UpdateAccessTokenUseCase(private val repository: TokenRepository) {

	suspend operator fun invoke(): String = repository.updateAccessToken()
}