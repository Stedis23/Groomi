package com.example.groomi.navigation

import com.example.splash.presentation.SplashRouter
import com.example.navigation.GlobalRouter
import com.example.welcome.WelcomeDestination

class SplashRouterImpl(
	private val router: GlobalRouter,
) : SplashRouter {

	override fun navigateToWelcome() {
		router.replace(WelcomeDestination)
	}

}