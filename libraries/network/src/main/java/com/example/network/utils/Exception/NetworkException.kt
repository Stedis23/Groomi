package com.example.network.utils.Exception

object NetworkCode {

	const val INTERNET_CONNECTION_ERROR = 3432523 // допустим
	const val SERVER_CONNECTION_ERROR = 544656 // допустим
	const val MISSING_VALUE = 677755 // допустим
	const val UNKNOWN = 78885 // допустим
	const val EMPTY_BODY = 67898 // допустим
	const val UNAUTHORIZED = 401
	const val NOT_FOUND = 404
	const val OK = 200
	const val FAIL = 400
	const val FORBIDDEN = 403
	const val CONFLICT = 409
}

data class NetworkException(
	override val message: String?,
	override val code: Int
) : BaseException(message, code)