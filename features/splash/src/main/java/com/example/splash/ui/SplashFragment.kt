package com.example.splash.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf

import com.example.splash.databinding.FragmentSplashBinding
import com.example.splash.presentation.SplashViewModel
import com.example.viewbinding.BindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashFragment :
	BindingFragment<FragmentSplashBinding>() {

	companion object {

		private const val FIRST_START_FLAG = "FIRST_START_FLAG"

		fun newInstance(firstStartFlag: Boolean): SplashFragment =
			SplashFragment().apply {
				arguments = bundleOf(FIRST_START_FLAG to firstStartFlag)
			}
	}

	private val viewModel: SplashViewModel by viewModel()

	override fun otherSetups() {}

	override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentSplashBinding =
		FragmentSplashBinding.inflate(inflater, container, false)
}