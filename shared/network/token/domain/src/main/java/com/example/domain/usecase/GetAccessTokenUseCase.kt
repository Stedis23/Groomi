package com.example.domain.usecase

import com.example.domain.repository.TokenRepository

class GetAccessTokenUseCase(private val repository: TokenRepository) {

	operator fun invoke(): String = repository.getAccessToken()
}