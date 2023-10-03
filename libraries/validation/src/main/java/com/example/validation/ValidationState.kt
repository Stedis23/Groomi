package com.example.validation

import com.example.validation.password.PasswordValidationError

sealed interface ValidationState

sealed class NameValidationState : ValidationState {

	object Unverified : NameValidationState()

	object Valid : NameValidationState()

	object EmptyName : NameValidationState()

	object InvalidName : NameValidationState()

	object InvalidNameLength : NameValidationState()
}

sealed class PasswordRepeatValidationState : ValidationState {

	object Unverified : PasswordRepeatValidationState()

	object Valid : PasswordRepeatValidationState()

	object Invalid : PasswordRepeatValidationState()
}

sealed class PasswordValidationState : ValidationState {

	object Unverified : PasswordValidationState()

	object Valid : PasswordValidationState()

	data class Invalid(val errorList: List<PasswordValidationError>) : PasswordValidationState()
}

sealed class EmailValidationState : ValidationState {

	object Unverified : EmailValidationState()

	object Valid : EmailValidationState()

	object EmptyEmail : EmailValidationState()

	object InvalidLengthBeforeAtSign : EmailValidationState()

	object InvalidLength : EmailValidationState()

	object InvalidEmail : EmailValidationState()
}

sealed class PhoneValidationState(open val maxLengthNumber: Int) : ValidationState {

	data class Unverified(override val maxLengthNumber: Int) : PhoneValidationState(maxLengthNumber)

	data class Valid(override val maxLengthNumber: Int) : PhoneValidationState(maxLengthNumber)

	data class EmptyPhone(override val maxLengthNumber: Int) : PhoneValidationState(maxLengthNumber)

	data class InvalidLength(override val maxLengthNumber: Int) : PhoneValidationState(maxLengthNumber)

	data class InvalidCountry(override val maxLengthNumber: Int) : PhoneValidationState(maxLengthNumber)

	data class InvalidPhone(override val maxLengthNumber: Int) : PhoneValidationState(maxLengthNumber)
}

sealed class NotEmptyValidationState : ValidationState {

	object Unverified : NotEmptyValidationState()

	object Valid : NotEmptyValidationState()

	object Invalid : NotEmptyValidationState()
}