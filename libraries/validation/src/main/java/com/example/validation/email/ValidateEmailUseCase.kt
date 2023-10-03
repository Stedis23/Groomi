package com.example.validation.email

import com.example.validation.EmailValidationState

class ValidateEmailUseCase {

	operator fun invoke(email: String): EmailValidationItem =
		when {
			EmailValidator.isEmailEmpty(email)                -> EmailValidationItem(email, EmailValidationState.EmptyEmail)
			!EmailValidator.isEmailLengthBeforeAtValid(email) -> EmailValidationItem(email, EmailValidationState.InvalidLengthBeforeAtSign)
			!EmailValidator.isEmailLengthAllValid(email)      -> EmailValidationItem(email, EmailValidationState.InvalidLength)
			EmailValidator.isInvalidEmail(email)              -> EmailValidationItem(email, EmailValidationState.InvalidEmail)
			else                                              -> EmailValidationItem(email, EmailValidationState.Valid)
		}
}