package com.example.validation.phone.phoneUtils

import io.michaelrocks.libphonenumber.android.PhoneNumberUtil

class GetNumberMaxLengthUseCase(private val phoneUtils: PhoneNumberUtil) {

	operator fun invoke(region: String): Int? {
		val regionNumber = phoneUtils.getExampleNumber(region)?.toString() ?: return null
		val regionMaxLength = regionNumber.replace("[^0-9]".toRegex(), "")
		return region.length.plus(regionMaxLength.length - 1)
	}
}