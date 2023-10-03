package com.example.main.presentation

import kotlinx.coroutines.flow.Flow

interface MainFragmentRouter {

	val currentScreenFlow: Flow<MainScreenState>

	fun clearBackStack()

	fun navigateToSalons()

	fun navigateToProfile()

	fun navigateToLoginSelection()

	fun goBack()
}