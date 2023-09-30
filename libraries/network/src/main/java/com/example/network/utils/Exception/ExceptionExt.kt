package com.example.network.utils.Exception

import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException
import java.net.UnknownHostException
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext


@Suppress("FunctionName")
inline fun CoroutineNetworkExceptionHandler(
	crossinline handler: (code: Int) -> Unit,
): CoroutineExceptionHandler =
	object : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {
		override fun handleException(context: CoroutineContext, exception: Throwable)  {
			handler.invoke(exception.toNetworkException().code)
		}
	}

fun Throwable.toNetworkException(): NetworkException {
	val code = when (this) {
		is UnknownHostException       -> NetworkCode.SERVER_CONNECTION_ERROR
		is NoConnectivityException    -> NetworkCode.INTERNET_CONNECTION_ERROR
		is HttpException              -> this.code()
		is NullPointerException,
		is KotlinNullPointerException -> NetworkCode.EMPTY_BODY
		else                          -> NetworkCode.UNKNOWN
	}
	return NetworkException(message = message, code = code)
}