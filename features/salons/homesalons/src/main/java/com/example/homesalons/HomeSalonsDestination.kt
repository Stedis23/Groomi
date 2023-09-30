package com.example.homesalons

import androidx.fragment.app.Fragment
import com.example.homesalons.ui.HomeSalonsFragment
import com.example.navigation.FragmentDestination

object HomeSalonsDestination : FragmentDestination {

	override fun createInstance(): Fragment =
		HomeSalonsFragment()
}