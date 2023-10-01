package com.example.splash

import androidx.fragment.app.Fragment
import com.example.splash.ui.SplashFragment
import com.example.navigation.FragmentDestination

data class SplashDestination(
	private val firstStartFlag: Boolean = false,
) : FragmentDestination {

	override fun createInstance(): Fragment
	= SplashFragment.newInstance(firstStartFlag)
}