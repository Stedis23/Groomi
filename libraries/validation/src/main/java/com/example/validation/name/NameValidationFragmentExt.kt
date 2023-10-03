package com.example.validation.name

import com.example.core.setErrorMessage
import com.google.android.material.textfield.TextInputLayout
import com.example.validation.NameValidationState
import com.example.validation.R

fun TextInputLayout.setNameValidationError(validationState: NameValidationState, partName: NamePart) =
	when (partName) {
		NamePart.NAME       -> setErrorMessage(getFirstNameValidationError(validationState))
		NamePart.SURNAME    -> setErrorMessage(getSurnameValidationError(validationState))
		NamePart.PATRONYMIC -> setErrorMessage(getPatronymicValidationError(validationState))
	}

private fun TextInputLayout.getFirstNameValidationError(validationState: NameValidationState) =
	when (validationState) {
		NameValidationState.EmptyName         -> resources.getString(R.string.validators_error_empty_firstName)
		NameValidationState.InvalidName       -> resources.getString(R.string.validators_error_invalid_symbol)
		NameValidationState.InvalidNameLength -> resources.getString(R.string.validators_error_not_len_50)
		else                                  -> null
	}

private fun TextInputLayout.getSurnameValidationError(validationState: NameValidationState) =
	when (validationState) {
		NameValidationState.EmptyName         -> resources.getString(R.string.validators_error_empty_lastName)
		NameValidationState.InvalidName       -> resources.getString(R.string.validators_error_invalid_symbol)
		NameValidationState.InvalidNameLength -> resources.getString(R.string.validators_error_not_len_50)
		else                                  -> null
	}

private fun TextInputLayout.getPatronymicValidationError(validationState: NameValidationState) =
	when (validationState) {
		NameValidationState.InvalidName       -> resources.getString(R.string.validators_error_invalid_symbol)
		NameValidationState.InvalidNameLength -> resources.getString(R.string.validators_error_not_len_50)
		else                                  -> null
	}