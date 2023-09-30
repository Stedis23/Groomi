package ru.shiftlab.cftteam.libraries.navigation

import kotlinx.coroutines.flow.StateFlow

interface MainRouter {

	val currentScreen: StateFlow<FragmentDestination>

	fun open(fragmentDestination: FragmentDestination)

	fun exit()

	fun clearBackStack()
}