package com.example.validation.PasswordRepeat

import com.example.core.setErrorMessage
import com.google.android.material.textfield.TextInputLayout
import com.example.validation.PasswordRepeatValidationState
import com.example.validation.R

fun TextInputLayout.setPasswordRepeatValidationError(validationState: PasswordRepeatValidationState) =
	when (validationState) {
		PasswordRepeatValidationState.Invalid -> setErrorMessage(resources.getString(R.string.validators_error_not_equals_pass))
		else                                  -> setErrorMessage(null)
	}