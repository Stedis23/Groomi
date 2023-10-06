package com.example.network.utils.di

import com.example.network.utils.Interceptor.headersInterceptor
import com.example.network.utils.Interceptor.loggingInterceptor
import com.example.network.utils.Interceptor.noConnectionInterceptor
import com.example.network.utils.fake.fakeProvideOkHttpClient
import com.example.network.utils.fake.fakeServerInterceptor
import com.example.network.utils.retrofit.FAKE
import com.example.network.utils.retrofit.provideRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val HEADERS_INTERCEPTOR = "HEADERS_INTERCEPTOR"
const val LOG_INTERCEPTOR = "loggingInterceptor"
const val NO_CONNECT_INTERCEPTOR = "NO_CONNECT_INTERCEPTOR"
const val FAKE_SERVER_INTERCEPTOR = "FAKE_SERVER_INTERCEPTOR"
const val ANIMATION_DELAY_INTERCEPTOR = "ANIMATION_DELAY_INTERCEPTOR"
const val BACKEND = "BACKEND"
const val BACKEND_FAKE = "BACKEND_FAKE"
const val KEYSTORE_PASSWORD = "KEYSTORE_PASSWORD"

val NetworkModule = module {
	single(named(FAKE_SERVER_INTERCEPTOR)) { fakeServerInterceptor(androidContext()) }
	single(named(LOG_INTERCEPTOR)) { loggingInterceptor() }
	single(named(NO_CONNECT_INTERCEPTOR)) { noConnectionInterceptor(androidContext()) }
	single(named(HEADERS_INTERCEPTOR)) {
		headersInterceptor(
			tokenExistsUseCase = get(),
			getAccessTokenUseCase = get()
		)
	}

	single(named(FAKE)) {
		fakeProvideOkHttpClient(
			interceptors = listOf(
				get(named(FAKE_SERVER_INTERCEPTOR)),
				get(named(NO_CONNECT_INTERCEPTOR)),
				get(named(HEADERS_INTERCEPTOR)),
				get(named(LOG_INTERCEPTOR)),
			)
		)
	}

	single(named(FAKE)) {
		provideRetrofit(
			okHttpClient = get(named(FAKE)),
			url = getProperty(BACKEND_FAKE)
		)
	}
}