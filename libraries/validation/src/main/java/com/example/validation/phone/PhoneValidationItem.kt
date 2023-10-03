package com.example.validation.phone

import com.example.validation.PhoneValidationState
import com.example.validation.ValidationItem

internal const val DEFAULT_MAX_LENGTH = 16

data class PhoneValidationItem(
	override val data: String = "",
	override val validationState: PhoneValidationState = PhoneValidationState.Unverified(DEFAULT_MAX_LENGTH)
) : ValidationItem<PhoneValidationState>()

fun PhoneValidationItem.isValid() = validationState is PhoneValidationState.Valid