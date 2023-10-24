package com.example.main.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.TokenExistsUseCase
import kotlinx.coroutines.flow.Flow

class MainViewModel(
	private val tokenExistsUseCase: TokenExistsUseCase,
	private val router: MainFragmentRouter,
) : ViewModel() {

	val currentScreenFlow: Flow<MainScreenState> = router.currentScreenFlow

	init {
		router.clearBackStack()
		router.navigateToSalons()
	}

	fun navigateToSalons() {
		router.navigateToSalons()
	}

	fun navigateToProfile() {
		if (tokenExistsUseCase()) {
			router.navigateToProfile()
		} else {
			router.navigateToLoginSelection()
		}
	}

	fun navigateBack() {
		router.goBack()
	}
}