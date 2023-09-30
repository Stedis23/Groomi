package com.example.homesalons.di

import com.example.homesalons.presentation.HomeSalonsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModelModule = module {
	viewModel {
		HomeSalonsViewModel()
	}
}

val HomeSalonsModules = listOf(
	viewModelModule,
)