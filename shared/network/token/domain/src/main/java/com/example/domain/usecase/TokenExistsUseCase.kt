package com.example.domain.usecase

import com.example.domain.repository.TokenRepository

class TokenExistsUseCase(private val repository: TokenRepository) {

	operator fun invoke(): Boolean = repository.checkTokenExists()
}