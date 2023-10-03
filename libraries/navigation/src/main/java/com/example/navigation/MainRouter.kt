package com.example.navigation

import kotlinx.coroutines.flow.StateFlow

interface MainRouter {

	val currentScreenFlow: StateFlow<FragmentDestination>

	fun open(fragmentDestination: FragmentDestination)

	fun exit()

	fun clearBackStack()
}