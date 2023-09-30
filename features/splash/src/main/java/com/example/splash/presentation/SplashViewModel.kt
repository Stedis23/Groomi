package com.example.splash.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.shiftlab.cftteam.features.splash.presentation.SplashRouter

class SplashViewModel(
	private val router: SplashRouter,
) : ViewModel(){

	init{
		startNavigation()
	}

	private fun startNavigation(){
		router.navigateToHomeSalons()
	}
}