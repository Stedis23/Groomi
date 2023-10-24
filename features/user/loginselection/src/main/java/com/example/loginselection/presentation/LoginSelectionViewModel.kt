package com.example.loginselection.presentation

import androidx.lifecycle.ViewModel

class LoginSelectionViewModel(
	private val router: LoginSelectionRouter,
) : ViewModel() {

	fun navigateToSignUp() {
		router.navigateToSignUp()
	}

	fun navigateToSingIn() {
		router.navigateToSingIn()
	}
}