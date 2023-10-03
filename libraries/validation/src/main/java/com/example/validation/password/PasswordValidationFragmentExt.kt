package com.example.validation.password

import com.example.core.setErrorMessage
import com.example.core.setHelperMessage
import com.google.android.material.textfield.TextInputLayout
import com.example.validation.PasswordValidationState
import com.example.validation.R
import com.example.theme.R as ThemeR

fun TextInputLayout.setHelperOrErrorText(validationState: PasswordValidationState) {
	when (validationState) {
		is PasswordValidationState.Invalid -> {
			helperText = null
			setErrorMessage(getErrorMessage(validationState.errorList))
		}

		PasswordValidationState.Unverified -> {
			error = null
			isErrorEnabled = false
			setHelperMessage(getHelperMessage())
		}

		PasswordValidationState.Valid      -> {
			error = null
			isErrorEnabled = false
			helperText = null
			editText?.setBackgroundResource(ThemeR.drawable.shape_text_field_background)
		}
	}
}

private fun TextInputLayout.getErrorMessage(errorList: List<PasswordValidationError>): String =
	errorList.map {
		getPasswordValidationMessage(it)
	}.toFormattedString()

private fun TextInputLayout.getPasswordValidationMessage(validationError: PasswordValidationError) =
	when (validationError) {
		PasswordValidationError.LENGTH_INVALID          -> resources.getString(R.string.validators_error_not_len_pass)
		PasswordValidationError.NO_DIGITS               -> resources.getString(R.string.validators_error_should_contain_numbers)
		PasswordValidationError.NO_LOWERCASE_CHARACTERS -> resources.getString(R.string.validators_error_low_pass)
		PasswordValidationError.NO_UPPERCASE_CHARACTERS -> resources.getString(R.string.validators_error_upp_pass)
		PasswordValidationError.INVALID_CHARACTERS      -> resources.getString(R.string.validators_error_invalid_symbols_pass)
	}

private fun TextInputLayout.getHelperMessage(): String =
	listOf(
		resources.getString(R.string.validators_error_not_len_pass),
		resources.getString(R.string.validators_error_should_contain_numbers),
		resources.getString(R.string.validators_error_low_pass),
		resources.getString(R.string.validators_error_upp_pass),
	).toFormattedString()

internal fun List<String>.toFormattedString(): String {
	val stringBuilder = StringBuilder()

	repeat(lastIndex) {
		stringBuilder.appendLine("• ${this[it]}")
	}

	if (isNotEmpty()) {
		stringBuilder.append("• ${this[lastIndex]}")
	}

	return stringBuilder.toString()
}