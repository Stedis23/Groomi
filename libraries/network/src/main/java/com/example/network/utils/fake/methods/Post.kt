package com.example.network.utils.fake.methods

import android.content.Context
import android.net.Uri
import com.example.network.R
import com.example.network.utils.fake.ext.create
import com.example.network.utils.fake.ext.error404
import com.example.network.utils.fake.ext.getJson
import com.example.network.utils.fake.ext.toRegexPath
import okhttp3.Response

internal fun post(context: Context, uri: Uri, response: Response.Builder): Response.Builder {
	val path = uri.path ?: return response.error404()

	return when (path.toRegexPath()) {

		"/api/v1/user/token-refresh".toRegexPath()         -> {
			response.create(
				description = "refresh token",
				body = context.getJson(R.raw.get_token_refresh),
			)
		}

		else -> {
			response.error404()
		}
	}
}

