package com.example.network.utils.fake.ext

import android.content.Context
import android.util.Log
import androidx.annotation.RawRes
import com.example.network.utils.Exception.NetworkCode
import com.example.network.utils.fake.LOG_TAG
import com.example.network.utils.fake.MEDIA_TYPE_JSON
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody

internal fun Response.Builder.create(code: Int = NetworkCode.OK, description: String, body: String = "") =
	code(code)
		.message(description)
		.body(body.toResponseBody(MEDIA_TYPE_JSON.toMediaTypeOrNull()))

internal fun Response.Builder.create(code: Int = NetworkCode.OK, description: String, body: ResponseBody) =
	code(code)
		.message(description)
		.body(body)

internal fun Response.Builder.error404() =
	create(code = NetworkCode.NOT_FOUND, description = NetworkCode.NOT_FOUND.toString(), body = """{ "error": "NOT API" }""")
		.also { Log.d(LOG_TAG, NetworkCode.NOT_FOUND.toString()) }

internal fun <K> Response.Builder.create(
	key: K,
	context: Context,
	log: Boolean = true,
	keyToJson: Map<K, FakeResponse>,
	defaultResponse: FakeResponse? = null
): Response.Builder {
	val response = keyToJson[key]
	return if (response == null) {
		if (defaultResponse == null) {
			error404()
		} else {
			this@create.create(
				code = defaultResponse.code,
				description = defaultResponse.description,
				body = defaultResponse.res?.let { context.getJson(it, log) }.orEmpty(),
			)
		}
	} else {
		this@create.create(
			code = response.code,
			description = response.description,
			body = response.res?.let { context.getJson(it, log) }.orEmpty(),
		)
	}
}

internal data class FakeResponse(val code: Int = NetworkCode.OK, val description: String, @RawRes val res: Int? = null)