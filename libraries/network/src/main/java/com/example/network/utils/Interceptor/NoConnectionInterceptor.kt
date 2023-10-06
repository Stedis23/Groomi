package com.example.network.utils.Interceptor

import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.network.utils.Exception.NoConnectivityException
import okhttp3.Interceptor

internal fun noConnectionInterceptor(context: Context) = Interceptor { chain ->
	val checker = InternetCheck(context)
	return@Interceptor if (checker.connectionOff) {
		throw NoConnectivityException()
	} else {
		chain.proceed(chain.request())
	}
}

class InternetCheck(context: Context) {

	private val connectivityManager =
		context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

	val connectionOff: Boolean
		get() = !isConnectionOn()

	private fun isConnectionOn(): Boolean =
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			postAndroidMInternetCheck()
		} else {
			preAndroidMInternetCheck()
		}

	@TargetApi(Build.VERSION_CODES.M)
	private fun postAndroidMInternetCheck(): Boolean =
		connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.let {
			it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
		} ?: false

	@Suppress("DEPRECATION")
	private fun preAndroidMInternetCheck(): Boolean =
		connectivityManager.activeNetworkInfo?.let {
			it.type == ConnectivityManager.TYPE_WIFI || it.type == ConnectivityManager.TYPE_MOBILE
		} ?: false
}