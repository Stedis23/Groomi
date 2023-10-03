package com.example.validation.email

import com.example.core.setErrorMessage
import com.google.android.material.textfield.TextInputLayout
import com.example.validation.EmailValidationState
import com.example.validation.R

fun TextInputLayout.setEmailValidationError(validationState: EmailValidationState) =
	when (validationState) {
		EmailValidationState.EmptyEmail                -> setErrorMessage(resources.getString(R.string.validators_error_empty_email))
		EmailValidationState.InvalidEmail              -> setErrorMessage(resources.getString(R.string.validators_error_invalid_email))
		EmailValidationState.InvalidLength             -> setErrorMessage(resources.getString(R.string.validators_error_invalid_length_email))
		EmailValidationState.InvalidLengthBeforeAtSign -> setErrorMessage(resources.getString(R.string.validators_error_invalid_length_before_at_email))
		else                                           -> setErrorMessage(null)
	}