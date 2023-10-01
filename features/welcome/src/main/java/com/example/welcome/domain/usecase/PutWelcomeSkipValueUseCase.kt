package com.example.welcome.domain.usecase

import com.example.welcome.domain.datasource.SkipWelcomeSharedPrefDataSource

class PutWelcomeSkipValueUseCase(private val dataSource: SkipWelcomeSharedPrefDataSource) {

	operator fun invoke() {
		dataSource.insert()
	}
}