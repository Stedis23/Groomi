package com.example.domain.usecase

import com.example.domain.entity.TokenBundleEntity
import com.example.domain.repository.TokenRepository

class SaveTokenBundleUseCase(private val tokenRepository: TokenRepository) {

	operator fun invoke(tokenBundleEntity: TokenBundleEntity) {
		tokenRepository.saveTokenBundle(tokenBundleEntity)
	}
}