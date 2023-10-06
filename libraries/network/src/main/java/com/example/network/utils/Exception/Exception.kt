package com.example.network.utils.Exception

import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import okhttp3.Interceptor
import java.io.IOException

class NoConnectivityException : IOException()