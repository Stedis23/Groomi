package com.example.profile

import androidx.fragment.app.Fragment
import com.example.navigation.FragmentDestination
import com.example.profile.ui.ProfileFragment

object ProfileDestination : FragmentDestination {

	override fun createInstance(): Fragment =
		ProfileFragment()
}