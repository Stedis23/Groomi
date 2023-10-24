package com.example.loginselection.di

import com.example.loginselection.presentation.LoginSelectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val LoginSelectionModule = module {
	viewModel {
		LoginSelectionViewModel(
			router = get()
		)
	}
}