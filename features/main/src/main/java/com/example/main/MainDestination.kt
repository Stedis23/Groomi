package com.example.main

import androidx.fragment.app.Fragment
import com.example.main.ui.MainFragment
import com.example.navigation.FragmentDestination

object MainDestination: FragmentDestination {

	override fun createInstance(): Fragment =
		MainFragment()
}