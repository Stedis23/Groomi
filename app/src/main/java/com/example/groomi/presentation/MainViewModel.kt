package com.example.groomi.presentation

import androidx.lifecycle.ViewModel

class MainViewModel(
	private val router: MainActivityRouter,
) : ViewModel() {

	private var mainRootOpened = false

	fun openMainRoot() {
		if (!mainRootOpened) {
			router.newRootScreen()
		}
		mainRootOpened = true
	}
}