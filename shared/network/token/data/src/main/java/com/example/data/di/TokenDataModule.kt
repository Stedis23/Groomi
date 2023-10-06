package com.example.data.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.shiftlab.cftteam.shared.network.token.data.api.RefreshTokenApi
import com.example.data.datasource.LocalTokenDataSource
import com.example.data.datasource.LocalTokenDataSourceImpl
import com.example.data.datasource.RemoteTokenDataSource
import com.example.data.datasource.RemoteTokenDataSourceImpl
import com.example.network.utils.retrofit.createRetrofitService
import ru.shiftlab.cftteam.shared.network.token.data.repository.TokenRepositoryImpl
import com.example.domain.repository.TokenRepository
import com.example.network.utils.retrofit.getRetrofit

val TokenDataModule = module {

	factory { createRetrofitService<RefreshTokenApi>(getRetrofit()) }
	single<LocalTokenDataSource> {
		LocalTokenDataSourceImpl(
			sharedPreferences = LocalTokenDataSourceImpl.getSharedPreferences(androidContext())
		)
	}
	single<RemoteTokenDataSource> { RemoteTokenDataSourceImpl(get()) }
	factory<TokenRepository> {
		TokenRepositoryImpl(
			localTokenDataSource = get(),
			remoteTokenDataSource = get()
		)
	}
}