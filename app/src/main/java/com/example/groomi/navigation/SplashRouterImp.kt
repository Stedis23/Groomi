package com.example.groomi.navigation

import com.example.homesalons.HomeSalonsDestination
import ru.shiftlab.cftteam.features.splash.presentation.SplashRouter
import com.example.navigation.GlobalRouter

class SplashRouterImpl(
	private val router: GlobalRouter,
) : SplashRouter {

	override fun navigateToHomeSalons() {
		router.replace(HomeSalonsDestination)
	}

}