package com.example.groomi

import android.app.Application
import com.example.groomi.navigation.di.AppModule
import com.example.groomi.navigation.di.RouterModule
import com.example.homesalons.di.HomeSalonsModules
import com.example.main.di.MainFragmentModule
import com.example.welcome.di.WelcomeModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import com.example.splash.di.SplashModule
import com.example.validation.di.ValidationModules

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@App)

			modules(AppModule)
			modules(MainFragmentModule)
			modules(RouterModule)
			modules(HomeSalonsModules)
			modules(SplashModule)
			modules(WelcomeModules)
			modules(ValidationModules)
		}
	}
}