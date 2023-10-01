package com.example.groomi.navigation

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.navigation.Destination
import com.example.navigation.FragmentDestination
import com.example.navigation.GlobalRouter
import com.example.navigation.IntentDestination

class GlobalRouterImpl(
	private val router: Router
) : GlobalRouter {

	override fun open(destination: Destination) {
		router.navigateTo(
			when (destination) {
				is FragmentDestination -> CreateInstanceFragmentScreen(destination)
				is IntentDestination   -> CreateInstanceActivityScreen(destination)
			}
		)
	}

	override fun replace(fragmentDestination: FragmentDestination) {
		router.replaceScreen(
			CreateInstanceFragmentScreen(fragmentDestination)
		)
	}

	override fun newRoot(fragmentDestination: FragmentDestination) {
		router.newRootScreen(
			CreateInstanceFragmentScreen(fragmentDestination)
		)
	}

	override fun popToRoot() {
		router.backTo(null)
	}

	override fun exit() {
		router.exit()
	}

	override fun finish() {
		router.finishChain()
	}

	override fun popTo(fragmentDestinationClass: Class<out FragmentDestination>) {
		router.backTo(
			BackToFragmentScreen(fragmentDestinationClass.name)
		)
	}
}

private class CreateInstanceFragmentScreen(
	private val fragmentDestination: FragmentDestination,
) : FragmentScreen {

	override val screenKey: String = fragmentDestination::class.java.name

	override fun createFragment(factory: FragmentFactory): Fragment =
		fragmentDestination.createInstance()

}

private class CreateInstanceActivityScreen(
	private val intentDestination: IntentDestination,
) : ActivityScreen {

	override val screenKey: String = intentDestination::class.java.name

	override fun createIntent(context: Context): Intent =
		intentDestination.createIntent()
}

private class BackToFragmentScreen(override val screenKey: String) : Screen