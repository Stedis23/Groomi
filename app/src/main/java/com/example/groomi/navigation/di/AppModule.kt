package com.example.groomi.navigation.di

import com.example.groomi.navigation.GlobalRouterImpl
import com.example.groomi.presentation.MainViewModel
import com.example.groomi.presentation.buildCicerone
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.example.navigation.GlobalRouter

val AppModule = module {
	factory { buildCicerone() }
	factory { get<Cicerone<Router>>().router }
	factory { get<Cicerone<Router>>().getNavigatorHolder() }
	factory <GlobalRouter> { GlobalRouterImpl(get()) }

	viewModel { MainViewModel(get()) }
}