package com.example.validation.email

import com.example.validation.EmailValidationState
import com.example.validation.ValidationItem

data class EmailValidationItem(
	override val data: String = "",
	override val validationState: EmailValidationState = EmailValidationState.Unverified
) : ValidationItem<EmailValidationState>()

fun EmailValidationItem.isValid() = validationState is EmailValidationState.Valid