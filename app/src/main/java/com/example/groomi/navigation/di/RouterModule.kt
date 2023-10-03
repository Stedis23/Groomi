package com.example.groomi.navigation.di

import com.example.groomi.navigation.MainActivityRouterImpl
import com.example.groomi.navigation.MainFragmentRouterImpl
import com.example.groomi.navigation.SplashRouterImpl
import com.example.groomi.navigation.WelcomeRouterImpl
import com.example.groomi.presentation.MainActivityRouter
import com.example.main.presentation.MainFragmentRouter
import com.example.welcome.presentation.WelcomeRouter
import org.koin.dsl.module
import com.example.splash.presentation.SplashRouter

val RouterModule = module {
	factory<MainActivityRouter> { MainActivityRouterImpl(get()) }
	factory<MainFragmentRouter> { MainFragmentRouterImpl(get()) }
	factory<SplashRouter> { SplashRouterImpl(get()) }
	factory<WelcomeRouter> { WelcomeRouterImpl(get()) }
}