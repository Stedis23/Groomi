package com.example.validation.phone.phoneUtils

import io.michaelrocks.libphonenumber.android.NumberParseException
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import io.michaelrocks.libphonenumber.android.Phonenumber.PhoneNumber

class GetRegionCodeForNumberUseCase(private val phoneUtils: PhoneNumberUtil) {

	operator fun invoke(number: String): String? {
		return try {
			val phoneNumber: PhoneNumber = phoneUtils.parse(number, null)
			phoneUtils.getRegionCodeForNumber(phoneNumber)
		} catch (e: NumberParseException) {
			return null
		}
	}
}