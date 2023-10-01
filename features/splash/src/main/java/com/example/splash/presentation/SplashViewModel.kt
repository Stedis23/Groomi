package com.example.splash.presentation

import androidx.lifecycle.ViewModel

class SplashViewModel(
	private val skipWelcome: Boolean,
	private val router: SplashRouter,
) : ViewModel(){

	init{
		startNavigation()
	}

	private fun startNavigation(){
		router.navigateToWelcome()
	}
}