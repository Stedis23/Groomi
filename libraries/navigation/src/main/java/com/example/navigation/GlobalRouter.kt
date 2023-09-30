package ru.shiftlab.cftteam.libraries.navigation

interface GlobalRouter {

	fun open(destination: Destination)

	fun replace(fragmentDestination: FragmentDestination)

	fun newRoot(fragmentDestination: FragmentDestination)

	fun popToRoot()

	fun exit()

	fun finish()

	fun popTo(fragmentDestinationClass: Class<out FragmentDestination>)
}