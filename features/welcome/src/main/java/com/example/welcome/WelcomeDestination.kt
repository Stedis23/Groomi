package com.example.welcome

import androidx.fragment.app.Fragment
import com.example.navigation.FragmentDestination
import com.example.welcome.ui.WelcomeFragment

object WelcomeDestination: FragmentDestination {

	override fun createInstance(): Fragment =
		WelcomeFragment()
}