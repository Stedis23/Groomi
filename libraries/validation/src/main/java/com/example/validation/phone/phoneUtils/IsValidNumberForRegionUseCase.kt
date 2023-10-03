package com.example.validation.phone.phoneUtils

import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import io.michaelrocks.libphonenumber.android.Phonenumber.PhoneNumber

class IsValidNumberForRegionUseCase(private val phoneUtils: PhoneNumberUtil) {

	operator fun invoke(number: String, region: String): Boolean {
		val phoneNumber: PhoneNumber = phoneUtils.parse(number, null)
		return phoneUtils.isValidNumberForRegion(phoneNumber, region)
	}
}