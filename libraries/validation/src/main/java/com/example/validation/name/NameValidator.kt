package com.example.validation.name

internal object NameValidator {

	private const val validCharRegexString = "^[a-zA-Zа-яА-ЯёЁ]+$"
	private const val blankStartRegexString = "^[-\\s]+.*"
	private const val blankEndRegexString = ".*[-\\s]+\$"
	private const val doubleSpaceRegexString = ".*[-\\s]{2,}.*"
	private val validLength = 1..50

	fun isNameInvalid(name: String?): Boolean = !with(name.orEmpty()) {
		!matches(blankStartRegexString.toRegex())
			&& !matches(blankEndRegexString.toRegex())
			&& !matches(doubleSpaceRegexString.toRegex())
			&& replace(" ", "")
			.replace("-", "")
			.matches(validCharRegexString.toRegex())
	}

	fun isNameEmpty(name: String?) = name.isNullOrEmpty()

	fun isNameLengthValid(name: String?) = name.orEmpty().length in validLength
}