package com.example.groomi.navigation

import com.example.groomi.presentation.MainActivityRouter
import com.example.splash.SplashDestination
import com.example.navigation.GlobalRouter


class MainActivityRouterImpl(
	private val router: GlobalRouter,
) : MainActivityRouter {

	override fun newRootScreen() {
		router.newRoot(SplashDestination())
	}
}