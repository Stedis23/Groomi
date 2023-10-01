package com.example.welcome.presentation

import androidx.lifecycle.ViewModel
import com.example.welcome.domain.usecase.PutWelcomeSkipValueUseCase

class WelcomeViewModel(
	private val putWelcomeSkipValueUseCase: PutWelcomeSkipValueUseCase,
	private val router: WelcomeRouter,
) : ViewModel() {

	fun navigateToRegistration() {
		putWelcomeSkipValueUseCase()
		router.navigateToRegistration()
	}

	fun navigateToMain() {
		putWelcomeSkipValueUseCase()
		router.navigateToMain()
	}

	fun navigateBack() {
		router.navigateBack()
	}
}