package com.example.validation.password

internal object PasswordValidator {

	private const val validCharactersRegexString = "[а-яёА-ЯЁa-zA-Z0-9_@!#$%&?.,\"]*"
	private const val containLowercaseRegexString = ".*[а-яёa-z].*"
	private const val containUppercaseRegexString = ".*[А-ЯЁA-Z].*"
	private const val containDigitsRegexString = ".*[0-9].*"
	private val validLength = 8..30

	fun passwordContainsOnlyValidCharacters(password: String): Boolean = password.matches(validCharactersRegexString.toRegex())

	fun isPasswordLengthValid(password: String): Boolean = password.length in validLength

	fun passwordContainLowercaseCharacters(password: String): Boolean = password.matches(containLowercaseRegexString.toRegex())

	fun passwordContainUppercaseCharacters(password: String): Boolean = password.matches(containUppercaseRegexString.toRegex())

	fun passwordContainDigits(password: String): Boolean = password.matches(containDigitsRegexString.toRegex())
}