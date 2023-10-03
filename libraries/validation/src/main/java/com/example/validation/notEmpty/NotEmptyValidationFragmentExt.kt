package com.example.validation.notEmpty

import com.example.core.setErrorMessage
import com.google.android.material.textfield.TextInputLayout
import com.example.validation.NotEmptyValidationState
import com.example.validation.R

fun TextInputLayout.setNotEmptyValidationError(validationState: NotEmptyValidationState) =
	when (validationState) {
		NotEmptyValidationState.Invalid -> setErrorMessage(resources.getString(R.string.validators_error_empty))
		else                            -> setErrorMessage(null)
	}