package com.example.validation.notEmpty

import com.example.validation.NotEmptyValidationState

class ValidateNotEmptyUseCase {

	operator fun invoke(data: String): NotEmptyValidationItem =
		when {
			data.isNotBlank() -> NotEmptyValidationItem(data, NotEmptyValidationState.Valid)
			else              -> NotEmptyValidationItem(data, NotEmptyValidationState.Invalid)
		}
}