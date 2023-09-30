package com.example.network.utils.Exception

open class BaseException(
	override val message: String? = null,
	open val code: Int? = null
) : Exception(message)