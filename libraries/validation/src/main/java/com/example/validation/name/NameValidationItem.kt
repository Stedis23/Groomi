package com.example.validation.name

import com.example.validation.NameValidationState
import com.example.validation.ValidationItem

data class NameValidationItem(
	override val data: String = "",
	override val validationState: NameValidationState = NameValidationState.Unverified,
	val namePart: NamePart,
) : ValidationItem<NameValidationState>()

fun NameValidationItem.isValid() = validationState is NameValidationState.Valid