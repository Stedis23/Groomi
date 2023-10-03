package com.example.validation.password

import com.example.validation.PasswordValidationState
import com.example.validation.ValidationItem

data class PasswordValidationItem(
	override val data: String = "",
	override val validationState: PasswordValidationState = PasswordValidationState.Unverified
) : ValidationItem<PasswordValidationState>()

fun PasswordValidationItem.isValid() = validationState is PasswordValidationState.Valid