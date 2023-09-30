package com.example.navigation

import com.example.navigation.FragmentDestination
import kotlinx.coroutines.flow.StateFlow

interface MainRouter {

	val currentScreen: StateFlow<FragmentDestination>

	fun open(fragmentDestination: FragmentDestination)

	fun exit()

	fun clearBackStack()
}