package com.example.groomi

import android.app.Application
import com.example.domain.di.TokenDomainModule
import com.example.groomi.navigation.di.AppModule
import com.example.groomi.navigation.di.RouterModule
import com.example.homesalons.di.HomeSalonsModules
import com.example.main.di.MainFragmentModule
import com.example.network.utils.di.BACKEND_FAKE
import com.example.network.utils.di.NetworkModule
import com.example.welcome.di.WelcomeModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import com.example.splash.di.SplashModule
import com.example.validation.di.ValidationModules
import com.example.data.di.TokenDataModule

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger(Level.ERROR)
			androidContext(this@App)
			properties(
				mapOf(
					BACKEND_FAKE to "https://fackeserver.ru",
				)
			)

			modules(AppModule)
			modules(MainFragmentModule)
			modules(RouterModule)
			modules(NetworkModule)
			modules(HomeSalonsModules)
			modules(SplashModule)
			modules(WelcomeModules)
			modules(ValidationModules)

			modules(TokenDomainModule)
			modules(TokenDataModule)
		}
	}
}