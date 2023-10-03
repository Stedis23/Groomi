package com.example.validation.PasswordRepeat

import com.example.validation.PasswordRepeatValidationState

class ValidatePasswordRepeatUseCase {

	operator fun invoke(password: String, passwordRepeat: String): PasswordRepeatValidationItem =
		when (password) {
			passwordRepeat -> PasswordRepeatValidationItem(passwordRepeat, PasswordRepeatValidationState.Valid)
			else           -> PasswordRepeatValidationItem(passwordRepeat, PasswordRepeatValidationState.Invalid)
		}
}