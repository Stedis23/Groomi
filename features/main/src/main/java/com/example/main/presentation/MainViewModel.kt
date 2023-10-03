package com.example.main.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class MainViewModel(
private val router: MainFragmentRouter
): ViewModel() {

	val currentScreenFlow: Flow<MainScreenState> = router.currentScreenFlow

	init {
		router.clearBackStack()
		router.navigateToSalons()
	}

	fun navigateToSalons() {
		router.navigateToSalons()
	}

	fun navigateToProfile() {
	}

	fun navigateBack() {
		router.goBack()
	}
}