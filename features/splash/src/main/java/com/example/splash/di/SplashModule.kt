package com.example.splash.di

import com.example.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SplashModule = module {
	viewModel {(skipWelcome: Boolean) ->
		SplashViewModel(
			skipWelcome = skipWelcome,
			router = get(),
		)
	}
}