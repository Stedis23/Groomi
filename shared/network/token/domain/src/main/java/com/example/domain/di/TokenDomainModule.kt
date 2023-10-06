package com.example.domain.di

import com.example.domain.usecase.ClearTokenBundleUseCase
import com.example.domain.usecase.GetAccessTokenUseCase
import com.example.domain.usecase.SaveTokenBundleUseCase
import com.example.domain.usecase.TokenExistsUseCase
import com.example.domain.usecase.UpdateAccessTokenUseCase
import org.koin.dsl.module

val TokenDomainModule = module {
	factory { GetAccessTokenUseCase(get()) }
	factory { TokenExistsUseCase(get()) }
	factory { SaveTokenBundleUseCase(get()) }
	factory { UpdateAccessTokenUseCase(get()) }
	factory { ClearTokenBundleUseCase(get()) }
}