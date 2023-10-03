package com.example.validation.email

import java.util.Locale

internal object EmailValidator {

	private const val validEmailRegexString = "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)" +
		"*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@" +
		"(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)" +
		"{3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"

	private const val AT = '@'

	private val validAllLength = 6..100

	private val validBeforeAtLength = 6..30

	fun isEmailEmpty(email: String) = email.isEmpty()

	fun isInvalidEmail(email: String) = !email.lowercase(Locale.ROOT).matches(validEmailRegexString.toRegex())

	fun isEmailLengthBeforeAtValid(email: String) =
		if (email.contains(AT)) {
			email.substringBefore(AT).length in validBeforeAtLength
		} else {
			true
		}

	fun isEmailLengthAllValid(email: String) = email.length in validAllLength
}