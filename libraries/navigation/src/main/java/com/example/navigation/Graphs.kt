package ru.shiftlab.cftteam.libraries.navigation

import android.content.Context
import androidx.annotation.NavigationRes

private const val NAVIGATION_MAIM_PROFILE = "navigation_main_profile"
private const val NAVIGATION_MAIN_REGISTRATION = "navigation_main_registration"
private const val NAVIGATION_GLOBAL = "navigation_global"

private const val NAVIGATION_TYPE = "navigation"

val Context.globalGraph: Int
	@NavigationRes get() = getGraph(NAVIGATION_GLOBAL)

val Context.mainProfileGraph: Int
	@NavigationRes get() = getGraph(NAVIGATION_MAIM_PROFILE)

val Context.mainRegistrationGraph: Int
	@NavigationRes get() = getGraph(NAVIGATION_MAIN_REGISTRATION)

@NavigationRes
fun Context.getGraph(name: String): Int =
	resources.getIdentifier(name, NAVIGATION_TYPE, packageName)