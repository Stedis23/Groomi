package com.example.loginselection

import androidx.fragment.app.Fragment
import com.example.loginselection.ui.LoginSelectionFragment
import com.example.navigation.FragmentDestination

object LoginSelectionDestination : FragmentDestination {

	override fun createInstance(): Fragment =
		LoginSelectionFragment()
}