package com.example.network.utils.Interceptor

import com.example.domain.usecase.GetAccessTokenUseCase
import com.example.domain.usecase.TokenExistsUseCase
import okhttp3.Interceptor
import okhttp3.Request

internal fun headersInterceptor(
	getAccessTokenUseCase: GetAccessTokenUseCase,
	tokenExistsUseCase: TokenExistsUseCase
) = Interceptor { chain ->
	val original = chain.request()
	return@Interceptor if (tokenExistsUseCase()) {
		val requestBuilder: Request.Builder = original.newBuilder()
			.addHeader("Authorization", "Bearer ${getAccessTokenUseCase()}")
		val request: Request = requestBuilder.build()
		chain.proceed(request)
	} else {
		chain.proceed(original)
	}
}