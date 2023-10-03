package com.example.groomi.navigation


import com.example.homesalons.HomeSalonsDestination
import com.example.main.presentation.MainFragmentRouter
import com.example.main.presentation.MainScreenState
import com.example.navigation.MainRouter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainFragmentRouterImpl(
	private val router: MainRouter
): MainFragmentRouter {

	override val currentScreenFlow: Flow<MainScreenState> =
		router.currentScreenFlow.map {
			when (it) {
				HomeSalonsDestination  -> MainScreenState.SALONS
				ProfileDestination     -> MainScreenState.PROFILE
				LoginSelectionDestination -> MainScreenState.LOGIN_SELECTION
				else                      -> throw IllegalAccessException("MainFragmentRouterImpl doesnt work with ${it::class.simpleName}")
			}
		}

	override fun clearBackStack() {
		router.clearBackStack()
	}

	override fun navigateToSalons() {
		router.open(HomeSalonsDestination)
	}

	override fun navigateToProfile() {
		router.open(ProfileDestination)
	}

	override fun navigateToLoginSelection() {
		router.open(LoginSelectionDestination)
	}

	override fun goBack() {
		router.exit()
	}
}