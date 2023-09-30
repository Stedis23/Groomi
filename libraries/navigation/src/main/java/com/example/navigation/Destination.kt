package ru.shiftlab.cftteam.libraries.navigation

import android.content.Intent
import androidx.fragment.app.Fragment

sealed interface Destination

interface FragmentDestination : Destination {

	fun createInstance(): Fragment
}

interface IntentDestination : Destination {

	fun createIntent(): Intent
}