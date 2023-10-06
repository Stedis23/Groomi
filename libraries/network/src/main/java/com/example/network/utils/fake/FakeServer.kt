package com.example.network.utils.fake

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.network.utils.Exception.NoConnectivityException
import com.example.network.utils.fake.ext.error404
import com.example.network.utils.fake.methods.delete
import com.example.network.utils.fake.methods.get
import com.example.network.utils.fake.methods.patch
import com.example.network.utils.fake.methods.post
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import java.net.InetSocketAddress
import java.net.Socket

internal const val LOG_TAG = "FakeServerLog"

private const val GET = "GET"
private const val POST = "POST"
private const val PATCH = "PATCH"
private const val DELETE = "DELETE"

private const val NUMBER_PORT = 53
private const val VALUE_TIMEOUT = 1500
private const val HOSTNAME = "8.8.8.8"
internal const val CONTENT_TYPE = "content-type"
internal const val MEDIA_TYPE_JSON = "application/json"

fun fakeServerInterceptor(context: Context) = Interceptor { chain ->
	checkInternetConnection(
		onSuccess = {
			val response = Response.Builder()
				.request(chain.request())
				.protocol(Protocol.HTTP_2)
				.addHeader(CONTENT_TYPE, MEDIA_TYPE_JSON)
			startFakeResponse(context, chain.request().url.toString(), response, chain).build()
		},
		onError = {
 			throw NoConnectivityException()
		}
	)
}

private fun startFakeResponse(
	context: Context,
	url: String,
	response: Response.Builder,
	chain: Interceptor.Chain
): Response.Builder {
	Log.d(LOG_TAG, url)
	val uri = Uri.parse(url)
	return when (chain.request().method) {
		GET    -> get(context, uri, response)
		POST   -> post(context, uri, response)
		PATCH  -> patch(context, uri, response)
		DELETE -> delete(context, uri, response)
		else   -> response.error404()
	}
}

private fun checkInternetConnection(onError: () -> Response, onSuccess: () -> Response): Response {
	try {
			Socket().connect(InetSocketAddress(HOSTNAME, NUMBER_PORT), VALUE_TIMEOUT)
			Socket().close()
	} catch (e: Exception) {
		onError()
	}

	return onSuccess()
}