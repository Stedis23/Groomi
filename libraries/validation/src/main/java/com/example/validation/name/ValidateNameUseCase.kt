package com.example.validation.name

import com.example.validation.NameValidationState

class ValidateNameUseCase {

	operator fun invoke(name: String, partName: NamePart) =
		when {
			NameValidator.isNameEmpty(name)        -> validateEmptyName(name, partName)
			NameValidator.isNameInvalid(name)      -> NameValidationItem(name, NameValidationState.InvalidName, partName)
			!NameValidator.isNameLengthValid(name) -> NameValidationItem(name, NameValidationState.InvalidNameLength, partName)
			else                                   -> NameValidationItem(name, NameValidationState.Valid, partName)
		}

	private fun validateEmptyName(name: String, partName: NamePart): NameValidationItem =
		if (partName == NamePart.PATRONYMIC) NameValidationItem(name, NameValidationState.Valid, partName)
		else NameValidationItem(name, NameValidationState.EmptyName, partName)
}