package com.example.data.di

import android.util.Log
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
import com.example.network.utils.di.BACKEND_FAKE
import com.example.network.utils.di.LOG_INTERCEPTOR
import com.example.network.utils.di.NO_CONNECT_INTERCEPTOR
import com.example.network.utils.fake.fakeProvideOkHttpClient
import com.example.network.utils.fake.fakeServerInterceptor
import com.example.network.utils.retrofit.provideRetrofit
import org.koin.android.BuildConfig
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

private const val FAKE_TOKEN_SERVER_INTERCEPTOR = "FakeTokenServerInterceptor"
private const val TOKEN_FAKE = "TOKEN_FAKE"

val FakeTokenNetworkModule = module {
	single(named(FAKE_TOKEN_SERVER_INTERCEPTOR)) { fakeServerInterceptor(androidContext()) }

	single(named(TOKEN_FAKE)) {
		fakeProvideOkHttpClient(
			interceptors = listOf(
				get(named(FAKE_TOKEN_SERVER_INTERCEPTOR)),
				get(named(LOG_INTERCEPTOR)),
				get(named(NO_CONNECT_INTERCEPTOR)),
			)
		)
	}

	single(named(TOKEN_FAKE)) {
		provideRetrofit(
			okHttpClient = get(named(TOKEN_FAKE)),
			url = getProperty(BACKEND_FAKE)
		)
	}
}

val TokenDataModule = module {

	factory { createRetrofitService<RefreshTokenApi>(getTokenRetrofit()) }
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

private inline fun <reified T> Scope.getTokenRetrofit(): T =
	if (BuildConfig.DEBUG) {
		get(T::class, named(TOKEN_FAKE).also { Log.d("getRetrofit", it.value) })
	} else {
		get(T::class, named(TOKEN_FAKE))
	}