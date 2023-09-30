package com.example.groomi

import android.app.Application
import com.example.groomi.navigation.di.AppModule
import com.example.groomi.navigation.di.RouterModule
import com.example.homesalons.di.HomeSalonsModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import ru.shiftlab.cftteam.features.splash.di.SplashListModule

class App: Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin{
			androidLogger(Level.ERROR)
			androidContext(this@App)

			modules(AppModule)
			modules(RouterModule)
			modules(HomeSalonsModules)
			modules(SplashListModule)
		}
	}
}