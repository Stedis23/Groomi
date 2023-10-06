package com.example.network.utils.fake.ext

import android.content.Context
import android.util.Log
import androidx.annotation.RawRes
import com.example.network.utils.fake.LOG_TAG

internal fun Context.getJson(@RawRes res: Int, log: Boolean = true): String =
	resources.openRawResource(res).bufferedReader().use { it.readText() }
		.also { if (log) Log.d(LOG_TAG, "JSON\n $it") }