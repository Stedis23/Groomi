package ru.shiftlab.cftteam.features.splash.di

import com.example.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val SplashListModule = module {
	viewModel {(skipWelcome: Boolean) ->
		SplashViewModel(
			skipWelcome = skipWelcome,
			router = get(),
		)
	}
}