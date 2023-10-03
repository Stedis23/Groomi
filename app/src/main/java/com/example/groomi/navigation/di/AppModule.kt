package com.example.groomi.navigation.di

import com.example.groomi.navigation.GlobalRouterImpl
import com.example.groomi.navigation.GlobalRouterName
import com.example.groomi.navigation.GlobalRouterName.GLOBAL
import com.example.groomi.navigation.MainRouterImpl
import com.example.groomi.presentation.MainViewModel
import com.example.groomi.presentation.buildCicerone
import com.example.main.presentation.MainRouterName.MAIN
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.example.navigation.GlobalRouter
import com.example.navigation.MainRouter
import org.koin.core.qualifier.named
import org.koin.dsl.single

val AppModule = module {
	single(named(GLOBAL)) { buildCicerone() }
	single(named(GLOBAL)) { get<Cicerone<Router>>(named(GLOBAL)).router }
	single(named(GLOBAL)) { get<Cicerone<Router>>(named(GLOBAL)).getNavigatorHolder() }
	single<GlobalRouter> { GlobalRouterImpl(get(named(GLOBAL))) }

	single(named(MAIN)) { buildCicerone() }
	single(named(MAIN)) { get<Cicerone<Router>>(named(MAIN)).router }
	single(named(MAIN)) { get<Cicerone<Router>>(named(MAIN)).getNavigatorHolder() }
	single<MainRouter> { MainRouterImpl(get(named(MAIN))) }

	viewModel { MainViewModel(get()) }
}