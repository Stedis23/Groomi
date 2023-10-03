package com.example.groomi.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.homesalons.HomeSalonsDestination
import com.example.navigation.FragmentDestination
import com.example.navigation.MainRouter
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.MutableStateFlow

class MainRouterImpl(
	private val router: Router,
) : MainRouter {

	override val currentScreenFlow = MutableStateFlow<FragmentDestination>(HomeSalonsDestination)

	private val backStack = mutableListOf<FragmentDestination>()

	override fun open(fragmentDestination: FragmentDestination) {
		backStack.remove(fragmentDestination)
		backStack.add(fragmentDestination)
		currentScreenFlow.value = fragmentDestination
		router.navigateTo(
			CreateInstanceFragmentMainScreen(fragmentDestination)
		)
	}

	override fun exit() {
		backStack.removeLast()
		if (backStack.isNotEmpty()) {
			open(backStack.last())
		} else {
			router.finishChain()
		}
	}

	override fun clearBackStack() {
		backStack.clear()
	}
}

private class CreateInstanceFragmentMainScreen(
	private val fragmentDestination: FragmentDestination,
) : FragmentScreen {

	override val screenKey: String = fragmentDestination::class.java.name

	override fun createFragment(factory: FragmentFactory): Fragment =
		fragmentDestination.createInstance()
}