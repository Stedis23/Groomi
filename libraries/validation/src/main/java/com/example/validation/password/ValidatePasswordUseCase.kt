package com.example.validation.password

import com.example.validation.PasswordValidationState

class ValidatePasswordUseCase {

	operator fun invoke(password: String): PasswordValidationItem {
		val errorList = mutableListOf<PasswordValidationError>().apply {
			if (!PasswordValidator.isPasswordLengthValid(password)) add(PasswordValidationError.LENGTH_INVALID)

			if (!PasswordValidator.passwordContainDigits(password)) add(PasswordValidationError.NO_DIGITS)

			if (!PasswordValidator.passwordContainLowercaseCharacters(password)) add(PasswordValidationError.NO_LOWERCASE_CHARACTERS)

			if (!PasswordValidator.passwordContainUppercaseCharacters(password)) add(PasswordValidationError.NO_UPPERCASE_CHARACTERS)

			if (!PasswordValidator.passwordContainsOnlyValidCharacters(password)) add(PasswordValidationError.INVALID_CHARACTERS)
		}

		return if (errorList.isEmpty()) {
			PasswordValidationItem(password, PasswordValidationState.Valid)
		} else {
			PasswordValidationItem(password, PasswordValidationState.Invalid(errorList))
		}
	}
}