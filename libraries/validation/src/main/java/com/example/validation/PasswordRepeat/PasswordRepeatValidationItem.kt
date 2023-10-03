package com.example.validation.PasswordRepeat

import com.example.validation.PasswordRepeatValidationState
import com.example.validation.ValidationItem

data class PasswordRepeatValidationItem(
	override val data: String = "",
	override val validationState: PasswordRepeatValidationState = PasswordRepeatValidationState.Unverified
) : ValidationItem<PasswordRepeatValidationState>()

fun PasswordRepeatValidationItem.isValid() = validationState is PasswordRepeatValidationState.Valid