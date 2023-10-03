package com.example.validation.di

import org.koin.dsl.module
import com.example.validation.PasswordRepeat.ValidatePasswordRepeatUseCase
import com.example.validation.email.ValidateEmailUseCase
import com.example.validation.name.ValidateNameUseCase
import com.example.validation.notEmpty.ValidateNotEmptyUseCase
import com.example.validation.password.ValidatePasswordUseCase
import com.example.validation.phone.ValidatePhoneScenario
import com.example.validation.phone.phoneUtils.GetNumberMaxLengthUseCase
import com.example.validation.phone.phoneUtils.GetRegionCodeForNumberUseCase
import com.example.validation.phone.phoneUtils.IsValidNumberForRegionUseCase

private val UseCaseModule = module {
	factory { GetRegionCodeForNumberUseCase(phoneUtils = get()) }
	factory { GetNumberMaxLengthUseCase(phoneUtils = get()) }
	factory { IsValidNumberForRegionUseCase(phoneUtils = get()) }
	factory { ValidatePasswordRepeatUseCase() }
	factory { ValidatePasswordUseCase() }
	factory { ValidateNotEmptyUseCase() }
	factory { ValidateEmailUseCase() }
	factory { ValidateNameUseCase() }
}

private val ScenarioModule = module {
	factory {
		ValidatePhoneScenario(
			getRegionCodeForNumberUseCase = get(),
			getNumberMaxLengthUseCase = get(),
			isValidNumberForRegionUseCase = get()
		)
	}
}

val ValidationModules = listOf(
	UseCaseModule,
	ScenarioModule
)