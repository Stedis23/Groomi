package com.example.network.utils.fake

import okhttp3.Interceptor
import okhttp3.OkHttpClient

fun fakeProvideOkHttpClient(interceptors: List<Interceptor> = emptyList()) =
	OkHttpClient.Builder().apply {
		interceptors.forEach {
			addInterceptor(it)
		}
	}.build()