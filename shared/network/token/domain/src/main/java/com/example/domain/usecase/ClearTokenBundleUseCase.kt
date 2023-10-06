package com.example.domain.usecase

import com.example.domain.repository.TokenRepository

class ClearTokenBundleUseCase(private val repository: TokenRepository) {

	operator fun invoke() {
		repository.clearTokenBundle()
	}
}