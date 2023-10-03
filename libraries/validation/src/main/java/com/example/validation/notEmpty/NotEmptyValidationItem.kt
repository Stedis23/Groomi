package com.example.validation.notEmpty

import com.example.validation.NotEmptyValidationState
import com.example.validation.ValidationItem

data class NotEmptyValidationItem(
	override val data: String = "",
	override val validationState: NotEmptyValidationState = NotEmptyValidationState.Unverified
) : ValidationItem<NotEmptyValidationState>()

fun NotEmptyValidationItem.isValid() = validationState is NotEmptyValidationState.Valid