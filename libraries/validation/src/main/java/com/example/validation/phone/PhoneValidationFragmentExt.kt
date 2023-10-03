package com.example.validation.phone

import android.widget.EditText
import com.example.core.setErrorMessage
import com.google.android.material.textfield.TextInputLayout
import com.example.validation.PhoneValidationState
import com.example.validation.R
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

private const val RAW_MASK = "+_________________"

fun TextInputLayout.setPhoneValidationError(validationState: PhoneValidationState) =
	when (validationState) {
		is PhoneValidationState.EmptyPhone     -> setErrorMessage(resources.getString(R.string.validators_error_empty_phone))
		is PhoneValidationState.InvalidLength  -> setErrorMessage(resources.getString(R.string.validators_error_max_len_phone))
		is PhoneValidationState.InvalidCountry -> setErrorMessage(resources.getString(R.string.validators_error_country_detect_phone))
		is PhoneValidationState.InvalidPhone   -> setErrorMessage(resources.getString(R.string.validators_error_invalid_phone))
		else                                   -> setErrorMessage(null)
	}

fun setMaskPhone(editTextPhone: EditText) {
	val slots = UnderscoreDigitSlotsParser().parseSlots(RAW_MASK)
	val formatWatcher: FormatWatcher = MaskFormatWatcher(
		MaskImpl.createNonTerminated(slots)
	)
	formatWatcher.installOn(editTextPhone)
}
