package com.example.splash.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.splash.databinding.FragmentSplashBinding
import com.example.splash.presentation.SplashViewModel
import com.example.storege.PreferenceKeys.WELCOME_SKIP_VALUE
import com.example.storege.PreferenceNames.WELCOME_PREF
import com.example.viewbinding.BindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SplashFragment :
	BindingFragment<FragmentSplashBinding>() {

	private val viewModel: SplashViewModel by viewModel {
		parametersOf(
			requireContext().getSharedPreferences(WELCOME_PREF, Context.MODE_PRIVATE)
				.getBoolean(WELCOME_SKIP_VALUE, false)
		)
	}

	override fun otherSetups() {
		viewModel
	}

	override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentSplashBinding =
		FragmentSplashBinding.inflate(inflater, container, false)
}