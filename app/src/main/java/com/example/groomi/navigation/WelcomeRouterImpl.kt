package com.example.groomi.navigation

import com.example.main.MainDestination
import com.example.navigation.GlobalRouter
import com.example.welcome.presentation.WelcomeRouter

class WelcomeRouterImpl(
	private val router: GlobalRouter,
): WelcomeRouter {

	override fun navigateBack() {
		router.exit()
	}

	override fun navigateToRegistration() {
		TODO("Not yet implemented")
	}

	override fun navigateToMain() {
		router.replace(MainDestination)
	}
}