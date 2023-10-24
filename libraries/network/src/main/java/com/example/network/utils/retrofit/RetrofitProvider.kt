package com.example.network.utils.retrofit

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val FAKE = "FAKE_SERVER"
const val ORIGINAL = "ORIGINAL_SERVER"

inline fun <reified T> Scope.getRetrofit(attachedValue: String = FAKE): T =
	if (BuildConfig.DEBUG) {
		get(T::class, named(attachedValue).also { Log.d("getRetrofit", it.value) })
	} else {
		get(T::class, named(FAKE))
	}

fun provideRetrofit(
	okHttpClient: OkHttpClient,
	url: String
): Retrofit {
	return Retrofit.Builder()
		.client(okHttpClient)
		.baseUrl(url)
		.addConverterFactory(MoshiConverterFactory.create(provideMoshi()).asLenient())
		.build()
}

private fun provideMoshi(): Moshi {
	return Moshi
		.Builder()
		.add(KotlinJsonAdapterFactory())
		.build()
}
