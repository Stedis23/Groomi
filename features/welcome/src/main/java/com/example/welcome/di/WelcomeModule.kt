package com.example.welcome.di

import com.example.welcome.data.SkipWelcomeSharedPrefDataSourceImpl
import com.example.welcome.domain.datasource.SkipWelcomeSharedPrefDataSource
import com.example.welcome.domain.usecase.PutWelcomeSkipValueUseCase
import com.example.welcome.presentation.WelcomeViewModel
import com.example.welcome.ui.viewpager.RecyclerViewAdapter
import com.example.welcome.ui.viewpager.Slide
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewPagerModule = module {
	single { (slides: Array<Slide>) -> RecyclerViewAdapter(slides) }
}

internal val useCaseModule = module {
	factory { PutWelcomeSkipValueUseCase(get()) }
}
internal val dataSourceModule = module {
	single<SkipWelcomeSharedPrefDataSource> { SkipWelcomeSharedPrefDataSourceImpl(androidContext()) }
}
internal val viewModelModule = module {
	viewModel {
		WelcomeViewModel(
			putWelcomeSkipValueUseCase = get(),
			router = get(),
		)
	}
}

val WelcomeModules = arrayListOf(
	viewPagerModule,
	useCaseModule,
	dataSourceModule,
	viewModelModule,
)