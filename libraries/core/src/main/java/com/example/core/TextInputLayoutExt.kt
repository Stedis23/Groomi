package com.example.core

import com.google.android.material.textfield.TextInputLayout
import com.example.theme.R as ThemeR

fun TextInputLayout.setErrorMessage(message: String?) {
	if (message != null) {
		editText?.setBackgroundResource(ThemeR.drawable.shape_text_field_background_error)
	} else {
		editText?.setBackgroundResource(ThemeR.drawable.shape_text_field_background)
		isErrorEnabled = false
	}

	error = message
}

fun TextInputLayout.setHelperMessage(message: String) {
	helperText = message
	editText?.setBackgroundResource(ThemeR.drawable.shape_text_field_background)
}