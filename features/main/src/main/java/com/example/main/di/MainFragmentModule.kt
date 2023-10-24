package com.example.main.di

import com.example.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MainFragmentModule = module {
	viewModel {
		MainViewModel(
			tokenExistsUseCase = get(),
			router = get(),
		)
	}
}