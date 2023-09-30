package com.example.groomi.navigation.di

import com.example.groomi.navigation.MainActivityRouterImpl
import com.example.groomi.navigation.SplashRouterImpl
import com.example.groomi.presentation.MainActivityRouter
import org.koin.dsl.module
import ru.shiftlab.cftteam.features.splash.presentation.SplashRouter

val RouterModule = module {
	factory<MainActivityRouter> { MainActivityRouterImpl(get()) }
	factory<SplashRouter> { SplashRouterImpl(get()) }
}