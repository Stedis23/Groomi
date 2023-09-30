package com.example.navigation

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

class GroomiKeepStateNavigator constructor(
	activity: FragmentActivity,
	containerId: Int,
	manager: FragmentManager,
) : AppNavigator(
	activity, containerId, manager
) {

	override fun commitNewFragmentScreen(
		fragmentScreen: FragmentScreen,
		addToBackStack: Boolean
	) {
		val fragmentTransaction = fragmentManager.beginTransaction()

		fragmentManager.primaryNavigationFragment?.let(fragmentTransaction::hide)
		var fragment = fragmentManager.findFragmentByTag(fragmentScreen.screenKey)

		if (fragment == null) {
			fragment = fragmentScreen.createFragment(fragmentFactory)
			fragmentTransaction.add(containerId, fragment, fragmentScreen.screenKey)
		} else {
			fragmentTransaction.show(fragment)
		}

		fragmentTransaction.setPrimaryNavigationFragment(fragment)
		fragmentTransaction.setReorderingAllowed(true)
		fragmentTransaction.commit()
	}
}