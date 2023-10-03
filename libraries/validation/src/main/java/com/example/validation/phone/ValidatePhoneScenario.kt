package com.example.validation.phone

import com.example.validation.PhoneValidationState
import com.example.validation.phone.phoneUtils.GetNumberMaxLengthUseCase
import com.example.validation.phone.phoneUtils.GetRegionCodeForNumberUseCase
import com.example.validation.phone.phoneUtils.IsValidNumberForRegionUseCase

class ValidatePhoneScenario(
	private val getRegionCodeForNumberUseCase: GetRegionCodeForNumberUseCase,
	private val getNumberMaxLengthUseCase: GetNumberMaxLengthUseCase,
	private val isValidNumberForRegionUseCase: IsValidNumberForRegionUseCase
) {

	operator fun invoke(number: String): PhoneValidationItem {
		if (number.isEmpty()) {
			return PhoneValidationItem(number, PhoneValidationState.EmptyPhone(DEFAULT_MAX_LENGTH))
		}
		val region = getRegionCodeForNumberUseCase(number) ?: return PhoneValidationItem(number, PhoneValidationState.InvalidPhone(DEFAULT_MAX_LENGTH))
		val regionNumberMaxLength =
			getNumberMaxLengthUseCase(region) ?: return PhoneValidationItem(number, PhoneValidationState.InvalidPhone(DEFAULT_MAX_LENGTH))

		return when {
			number.length != regionNumberMaxLength         -> PhoneValidationItem(number, PhoneValidationState.InvalidLength(regionNumberMaxLength))

			!isValidNumberForRegionUseCase(number, region) -> PhoneValidationItem(number, PhoneValidationState.InvalidCountry(regionNumberMaxLength))

			else                                           -> PhoneValidationItem(number, PhoneValidationState.Valid(regionNumberMaxLength))
		}
	}
}