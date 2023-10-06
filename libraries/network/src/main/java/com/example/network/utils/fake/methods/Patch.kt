package com.example.network.utils.fake.methods

import android.content.Context
import android.net.Uri
import com.example.network.utils.fake.ext.error404
import com.example.network.utils.fake.ext.toRegexPath
import okhttp3.Response

internal fun patch(context: Context, uri: Uri, response: Response.Builder): Response.Builder {
	val path = uri.path ?: return response.error404()

	return when (path.toRegexPath()) {

		else -> {
			response.error404()
		}
	}
}